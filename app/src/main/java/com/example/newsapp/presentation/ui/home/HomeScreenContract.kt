package com.example.newsapp.presentation.ui.home

import com.example.newsapp.base.UiEffect
import com.example.newsapp.base.UiEvent
import com.example.newsapp.base.UiState
import com.example.newsapp.domain.model.NewsList

class HomeScreenContract {

    data class State (
        val isLoading : Boolean = false,
        val newList : List<NewsList> ?= emptyList(),
        val errorMessage : String = ""
    ) : UiState


    sealed class Event() : UiEvent{

    }

    sealed class Effect() : UiEffect {

    }

}