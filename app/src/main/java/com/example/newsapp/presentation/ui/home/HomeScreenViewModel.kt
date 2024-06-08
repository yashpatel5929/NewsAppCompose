package com.example.newsapp.presentation.ui.home

import androidx.lifecycle.viewModelScope
import com.example.newsapp.base.BaseViewModel
import com.example.newsapp.domain.repositories.NewsRepositories
import com.example.newsapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val newListRepositories: NewsRepositories
) : BaseViewModel<HomeScreenContract.State,HomeScreenContract.Event,HomeScreenContract.Effect>() {

    init {
        makeNewListApiCall()
    }
    override fun currentInitialState(): HomeScreenContract.State {
        return HomeScreenContract.State()
    }

    override fun handleEvent(event: HomeScreenContract.Event) {

    }

    private fun makeNewListApiCall()= viewModelScope.launch{
        setState { copy(isLoading = true) }
        when(val response = newListRepositories.getAllNews()){
            is Resource.Success -> {
                setState { copy(isLoading = false) }
                setState { copy(newList = response.data) }
            }

            is Resource.Error -> {
                setState { copy(isLoading = false) }
                setState { copy(errorMessage = response.message ?: "") }
            }
        }
    }

}