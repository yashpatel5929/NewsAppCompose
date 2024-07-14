package com.example.newsapp.presentation.ui.home

import android.util.Log
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.newsapp.base.BaseViewModel
import com.example.newsapp.domain.repositories.NewsRepositories
import com.example.newsapp.domain.usecases.TopStoriesUseCase
import com.example.newsapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val newListRepositories: NewsRepositories,
    private val topStoriesUseCase: TopStoriesUseCase
) : BaseViewModel<HomeScreenContract.State,HomeScreenContract.Event,HomeScreenContract.Effect>() {

    init {
        getTopStories()
//        makeNewListApiCall()
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

    fun getNewsCategories() = viewModelScope.launch {
        when(val response = newListRepositories.getNewCategories()){
            is Resource.Success -> {
                setState { copy(newsCategories = response.data) }
            }

            is Resource.Error -> {

            }
        }
    }

    fun getTopStories() = viewModelScope.launch {
        setState { copy(isLoading = true) }
        when(val response = topStoriesUseCase.invoke()) {
            is Resource.Success -> {
                setState { copy(isLoading = false) }
                setState { copy(topStories = response.data) }
            }

            is Resource.Error -> {
                setState { copy(isLoading = false) }
                setState { copy(errorMessage = response.message ?: "") }
            }
        }
    }

}