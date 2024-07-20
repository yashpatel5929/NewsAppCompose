package com.example.newsapp.presentation.ui.search

import androidx.lifecycle.viewModelScope
import com.example.newsapp.base.BaseViewModel
import com.example.newsapp.domain.repositories.NewsRepositories
import com.example.newsapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchScreenViewModel @Inject constructor(
    private val newListRepositories: NewsRepositories,
):
    BaseViewModel<SearchBarContract.State, SearchBarContract.SearchEvents, SearchBarContract.SearchEffect>()  {

        init {
            getNewList()
        }
    override fun currentInitialState(): SearchBarContract.State {
        return SearchBarContract.State()
    }

    override fun handleEvent(event: SearchBarContract.SearchEvents) {
        when(event) {
            is SearchBarContract.SearchEvents.SearchQuery -> {
                setState { copy(searchQuery = event.searchQuery ?: "") }
                searchFilter(event.searchQuery)
            }
        }

    }

    private fun searchFilter(searchQuery: String?) {
        if(searchQuery.isNullOrBlank()) {
            setState { copy(filterList = listOf()) }
        }else {
            setState { copy( filterList = currentUiState.newList?.filter { it.title?.contains(searchQuery , true) == true })}
        }
    }

    private fun getNewList()= viewModelScope.launch{
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