package com.example.newsapp.presentation.ui.search

import com.example.newsapp.base.UiEffect
import com.example.newsapp.base.UiEvent
import com.example.newsapp.base.UiState
import com.example.newsapp.domain.model.NewsList

class SearchBarContract {

    data class State(
        val isLoading : Boolean=false,
        val searchQuery : String = "",
        val newList :  List<NewsList> ?= emptyList(),
        val filterList :  List<NewsList> ?= emptyList(),
        val errorMessage: String = ""
    ) : UiState

    sealed class SearchEvents : UiEvent {
        data class SearchQuery(val searchQuery: String?) : SearchEvents()
    }


    sealed class SearchEffect() : UiEffect
}