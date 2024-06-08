package com.example.newsapp.presentation.ui.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import com.example.newsapp.base.UiEffect
import com.example.newsapp.base.UiEvent
import com.example.newsapp.base.UiState
import com.example.newsapp.presentation.component.pages

class OnBoardingContract {
    data class State (
        val prevButton : String = "Previous",
        val nextButton : String  ="Next",
        val pagerStateIndex : Int = 0
    ) : UiState

    sealed class Event : UiEvent {
        data  class NextPage(val nextButtonText : String ) : Event()
        data  class PreviousPage(val previousButtonText : String) : Event()
        data object Continue : Event()
    }

    sealed class Effect : UiEffect {
        data object ContinueToDashboard : Effect()
    }


}