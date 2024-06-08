package com.example.newsapp.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<State : UiState , Event : UiEvent , Effect : UiEffect> : ViewModel() {



    private val initialState : State by lazy { currentInitialState() }
    abstract fun currentInitialState() : State


    private val _uiState  : MutableStateFlow<State> = MutableStateFlow(initialState)
    val uiState = _uiState.asStateFlow()

    val currentUiState : State
        get() = uiState.value

    private val _event : MutableSharedFlow<Event> = MutableSharedFlow()
    val event = _event.asSharedFlow()

    private val _effect : Channel<Effect> = Channel()
    val effect = _effect.receiveAsFlow()

    init {
        subScribeEvent()
    }
    protected fun setState(reduce : State.() -> State){
        val newSate = currentUiState.reduce()
        _uiState.value = newSate
    }

    fun setEvent(event: Event) {
        val newEvent = event
        viewModelScope.launch { _event.emit(newEvent) }
    }

    protected fun setEffect(effect : () -> Effect){
        val newEffect = effect()
        viewModelScope.launch { _effect.send(newEffect)}
    }


    private fun subScribeEvent(){
        viewModelScope.launch {
            event.collect {
                handleEvent(it)
            }
        }
    }

    abstract fun handleEvent(event : Event)

}