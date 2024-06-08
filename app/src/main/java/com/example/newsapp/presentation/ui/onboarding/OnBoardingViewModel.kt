package com.example.newsapp.presentation.ui.onboarding

import androidx.compose.foundation.pager.PagerState
import com.example.newsapp.base.BaseViewModel

class OnBoardingViewModel :
    BaseViewModel<OnBoardingContract.State, OnBoardingContract.Event, OnBoardingContract.Effect>() {
    override fun currentInitialState(): OnBoardingContract.State {
        return OnBoardingContract.State()
    }

    override fun handleEvent(event: OnBoardingContract.Event) {
        when (event) {
            is OnBoardingContract.Event.PreviousPage -> {

                setState {
                    copy(prevButton = event.previousButtonText , pagerStateIndex = currentUiState.pagerStateIndex-1)
                }

            }

            is OnBoardingContract.Event.NextPage -> {
                setState {
                    copy(nextButton = event.nextButtonText, pagerStateIndex = currentUiState.pagerStateIndex+1 )
                }
            }

            is OnBoardingContract.Event.Continue -> {
                continueToDashBoard()
            }
        }
    }


    private fun continueToDashBoard() {
        setEffect {
            OnBoardingContract.Effect.ContinueToDashboard
        }
    }


}