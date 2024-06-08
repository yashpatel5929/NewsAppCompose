package com.example.newsapp.presentation.ui.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.newsapp.R
import com.example.newsapp.domain.model.BottomNavData
import com.example.newsapp.domain.model.NewsList
import com.example.newsapp.presentation.ui.component.BottomNavigationTab
import com.example.newsapp.utils.toDate


@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel,
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        if (uiState.newList?.isEmpty() == true && uiState.isLoading) {
            CircularProgressIndicator()
        } else {
            uiState.newList?.let { NewsList(modifier, it) }
        }
    }
}



@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NewsList(
    modifier: Modifier,
    newList: List<NewsList>,
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
    ) {
        items(count = newList.size) { i ->
            NewsItemList(modifier, newList[i])
            Divider(thickness = 3.dp)
        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NewsItemList(
    modifier: Modifier,
    news: NewsList
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 12.dp, end = 16.dp, bottom = 16.dp)
    ) {
        news.title?.let {
            Text(
                text = it,
                maxLines = 4,
                overflow = TextOverflow.Ellipsis, fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = modifier.padding(5.dp))
        news.description?.let { Text(text = it) }
        Spacer(modifier = modifier.padding(10.dp))
        news.publishAt?.let { Text(text = stringResource(id = R.string.publish_on, it.toDate())) }
        Spacer(modifier = modifier.padding(3.dp))
        news.author?.let { Text(text = stringResource(id = R.string.author, it)) }
    }
}