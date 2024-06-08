package com.example.newsapp.presentation.ui.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.newsapp.R
import com.example.newsapp.presentation.component.Pages
import com.example.newsapp.presentation.component.common.IndicatorAndButton
import com.example.newsapp.presentation.component.pages
import kotlinx.coroutines.flow.collectLatest

@Composable
fun OnBoardingScreen(
    viewModel : OnBoardingViewModel,
    modifier: Modifier,
    navigateToDashBoard : () -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val context = LocalContext.current
    Column(modifier = modifier) {

        LaunchedEffect(key1 = Unit){
            viewModel.effect.collectLatest {
                when(it) {
                    is OnBoardingContract.Effect.ContinueToDashboard -> {
                        navigateToDashBoard()
                    }
                }
            }
        }
        OnBoardingPagerScreen(modifier = modifier, page = pages[uiState.pagerStateIndex])
        IndicatorAndButton(
            modifier = modifier,
            pagesSize = pages.size,
            selectedPage = uiState.pagerStateIndex ?: 0,
            prevButtonText = uiState.prevButton,
            nextButtonText = uiState.nextButton,
            prevButtonClick = { viewModel.setEvent(OnBoardingContract.Event.PreviousPage(context.getString(
                R.string.prev)))} ,
            nextButtonClick = {
                if(uiState.pagerStateIndex != pages.size-1) {
                    viewModel.setEvent(OnBoardingContract.Event.NextPage(context.getString(R.string.next)))
                }else {
                    viewModel.setEvent(OnBoardingContract.Event.Continue)
                }
            })
    }

}

@Composable
fun OnBoardingPagerScreen(
    modifier: Modifier,
    page: Pages
) {
    Column(
        modifier = modifier
    ) {
        Image(
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight(0.6f),
            painter = painterResource(id = page.image), contentDescription = null
        )
        Spacer(modifier = modifier.height(10.dp))
        Text( modifier = modifier
            .fillMaxWidth()
            .padding(10.dp),text = page.title,
            style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Bold))
        Spacer(modifier = modifier.height(10.dp))
        Text( modifier = modifier
            .fillMaxWidth()
            .padding(10.dp),text = page.description)
    }

}