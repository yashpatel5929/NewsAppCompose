package com.example.newsapp.presentation.ui.search

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.newsapp.R
import com.example.newsapp.domain.model.NewsList
import com.example.newsapp.presentation.ui.home.NewsItemList


@Composable
fun SearchScreen(searchScreensViewModel: SearchScreenViewModel) {
    val uiState by searchScreensViewModel.uiState.collectAsStateWithLifecycle()
    Column {
        SearchBarTab(modifier = Modifier.statusBarsPadding() , uiState) {
            searchScreensViewModel.setEvent(SearchBarContract.SearchEvents.SearchQuery(it))
        }
        ShowSearchResult(modifier = Modifier , uiState)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBarTab(modifier: Modifier = Modifier, uiState: SearchBarContract.State , onEditTextValueChange : (String) -> Unit) {
    Row(modifier = modifier.fillMaxWidth()) {
        TextField(value = uiState.searchQuery, onValueChange = {
             onEditTextValueChange.invoke(it)
        }, leadingIcon = {
            Icon(imageVector = Icons.Filled.Search, contentDescription = null)
        }, placeholder = { Text(text = "Search") }, modifier = modifier
            .padding(12.dp)
            .fillMaxWidth(), shape = RoundedCornerShape(10.dp), singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ))
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ShowSearchResult(modifier: Modifier = Modifier, uiState: SearchBarContract.State,) {
    Box {
        if(uiState.filterList?.isNotEmpty() == true){
            SearchResultList(modifier, uiState.filterList)
        }else {
            NoDataFoundScreen(modifier)
        }
    }

}

@Composable
fun NoDataFoundScreen(modifier: Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.baseline_error_24),
            contentDescription = null,
            modifier = modifier
                .height(200.dp)
                .width(200.dp),
            contentScale = ContentScale.FillBounds,
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary)
        )
        Spacer(modifier = modifier.padding(10.dp))
        Text(
            text = "No Data Found",
            modifier = modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}


@Composable
fun SearchResultList(modifier: Modifier, filterList: List<NewsList>) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
    ) {
        items(count = filterList.size) { i ->
            NewsItemList(modifier, filterList[i])
            Divider(thickness = 3.dp)
        }
    }
}
