package com.example.newsapp.presentation.component.common

import android.opengl.Visibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.newsapp.R


@Composable
fun IndicatorAndButton(
    modifier: Modifier,
    pagesSize: Int,
    selectedPage: Int,
    prevButtonText : String,
    nextButtonText : String,
    prevButtonClick : () -> Unit,
    nextButtonClick : () -> Unit,
) {
    
    Row(modifier = modifier.fillMaxWidth()) {
        repeat(pagesSize) {
            indicators(modifier = modifier.padding(5.dp), isSelected = selectedPage == it)
        }
    }
    Row(modifier = modifier.fillMaxWidth() , Arrangement.End) {
        if(selectedPage != 0) {
            Button(onClick = { prevButtonClick() }) {
                Text(text = prevButtonText)
            }
        }

        Button(onClick = { nextButtonClick() } , modifier = modifier.padding(start = 10.dp , end = 10.dp)) {
            Text(text = nextButtonText)
        }
    }
    
}

@Composable
fun indicators(
    modifier: Modifier,
    isSelected : Boolean
){
    Row {
        Box(
            modifier = modifier
                .clip(CircleShape)
                .size(10.dp)
                .background(
                    color =
                    if (isSelected) Color.Cyan else Color.Gray
                )
        )
    }

}