package com.example.newsapp.presentation.ui.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.newsapp.R

@Composable
fun SearchScreen() {
    Column {
        SearchBarTab(modifier = Modifier.statusBarsPadding())
        ShowSearchResult()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBarTab(modifier: Modifier = Modifier) {
    Row(modifier = modifier.fillMaxWidth()){
        TextField(value = "", onValueChange = {}, leadingIcon = {
            Icon(imageVector = Icons.Filled.Search, contentDescription = null)
        }, placeholder = { Text(text = "Search") } , modifier = modifier
            .padding(12.dp)
            .fillMaxWidth(), shape = RoundedCornerShape(10.dp), singleLine = true,
            colors = TextFieldDefaults.textFieldColors(focusedIndicatorColor = Color.Transparent , unfocusedIndicatorColor = Color.Transparent))
    }
}

@Composable
fun ShowSearchResult(modifier: Modifier = Modifier) {
    Box {
//        SearchResultList(modifier)
        NoDataFoundScreen(modifier)
    }

}

@Composable
fun NoDataFoundScreen(modifier: Modifier) {
    Column(modifier = modifier.fillMaxSize() ,verticalArrangement = Arrangement.Center , horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(id = R.drawable.baseline_error_24), contentDescription = null , modifier = modifier.height(200.dp).width(200.dp) , contentScale = ContentScale.FillBounds , colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary))
        Spacer(modifier = modifier.padding(10.dp))
        Text(text = "No Data Found" , modifier = modifier.fillMaxWidth() , textAlign = TextAlign.Center)
    }
}

@Composable
fun SearchResultList(modifier: Modifier) {
    Text(text = "Found Some Data")
}
