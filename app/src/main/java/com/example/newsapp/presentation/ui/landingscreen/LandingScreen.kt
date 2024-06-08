package com.example.newsapp.presentation.ui.landingscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import com.example.newsapp.R
import kotlinx.coroutines.delay

@Composable
fun LandingScreen(onTimeOut : () -> Unit , modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize() , contentAlignment = Alignment.Center) {
        val currentUpdatedTime by rememberUpdatedState(newValue = onTimeOut)

        LaunchedEffect(key1 = Unit) {
            delay(2000)
            currentUpdatedTime()
        }
        
        Image(painter = painterResource(id = R.drawable.logo), contentDescription = null )
    }


}