package com.example.newsapp.presentation.ui.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.annotation.StringRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.SubcomposeAsyncImage
import com.example.newsapp.R
import com.example.newsapp.domain.model.NewsList
import com.example.newsapp.domain.model.TopStoriesModel
import com.example.newsapp.utils.toDate


@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel,
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        if (uiState.topStories?.isEmpty() == true && uiState.isLoading) {
            CircularProgressIndicator()
        } else {
           viewModel.getNewsCategories()

           HomeScreenWithSection(modifier , uiState)
//            uiState.newList?.let { NewsList(modifier, it) }
        }
    }
}

@Composable
fun HomeScreenWithSection(
    modifier: Modifier = Modifier,
    uiState: HomeScreenContract.State,
) {
    Column(modifier = modifier.verticalScroll(rememberScrollState())) {
        Box(modifier = modifier
            .fillMaxHeight(0.3f)
            .padding(16.dp)) {
            uiState.topStories?.let { HomeNewCardCarousel(modifier = modifier , it) }
        }

        HomeSection(title = R.string.categories) {

           NewsCategories(modifier = modifier , uiState.newsCategories)
        }

        HomeSection(title = R.string.categories) {

            NewsCategories(modifier = modifier , uiState.newsCategories)
        }
    }
}

@Composable
fun HomeSection(modifier: Modifier = Modifier,
                @StringRes title :  Int ,
                content : @Composable () -> Unit) {

    Column(modifier) {
        Text(text = stringResource(id = title),
            style = MaterialTheme.typography.titleMedium,
            modifier = modifier
                .paddingFromBaseline(top = 40.dp, bottom = 16.dp)
                .padding(horizontal = 16.dp))
        content()
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun  HomeNewCardCarousel(modifier: Modifier = Modifier, topStories: List<TopStoriesModel>){
        val pagerState = rememberPagerState { topStories.size }
    HorizontalPager(state = pagerState) {
        topStories.get(it).let { it1 -> ImageCard(modifier =  modifier,newsData = it1) }


    }


}

@Composable
fun ImageCard(modifier: Modifier = Modifier , newsData : TopStoriesModel) {
    Card (modifier = modifier.fillMaxWidth(), shape = RoundedCornerShape(15.dp) , elevation = CardDefaults.cardElevation(5.dp)){
        Box (modifier = modifier.height(290.dp)) {
            Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                SubcomposeAsyncImage(model = newsData.imageUrl, contentDescription = null, loading = {    CircularProgressIndicator()} , contentScale = ContentScale.FillBounds)
            }
            Box(
                modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 300f
                        )
                    )
            ) {

            }
            Box(modifier = modifier
                .fillMaxSize()
                .padding(12.dp),
                contentAlignment = Alignment.BottomStart) {
                Column {
                    Text(
                        text = newsData.title.toString(),
                        style = MaterialTheme.typography.titleMedium,
                        modifier = modifier
                            .padding(horizontal = 16.dp)
                    )
                    Spacer(modifier = Modifier.padding(5.dp))
                    Text(
                        text = newsData.description.toString(),
                        style = MaterialTheme.typography.titleLarge,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        modifier = modifier
                            .padding(horizontal = 16.dp)
                    )
                }

            }
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