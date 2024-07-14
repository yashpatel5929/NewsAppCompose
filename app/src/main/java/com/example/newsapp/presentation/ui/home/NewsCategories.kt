package com.example.newsapp.presentation.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.newsapp.domain.model.NewsCategories

@Composable
fun NewsCategories(modifier: Modifier = Modifier, newsCategories: List<NewsCategories>?) {
    LazyHorizontalGrid(rows = GridCells.Fixed(2) , modifier = modifier.height(200.dp)) {
        items(newsCategories?.size ?: 0 ) {
            newsCategories?.get(it)?.let { it1 -> ItemNewsCategories(modifier = modifier , newsCategories = it1) }
        }
    }
}

@Composable
fun ItemNewsCategories(modifier: Modifier = Modifier , newsCategories: NewsCategories) {
    Card(
        modifier = modifier.padding(8.dp).fillMaxSize(),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Column(modifier = modifier.padding(10.dp).width(150.dp), horizontalAlignment = Alignment.CenterHorizontally , verticalArrangement = Arrangement.Center ) {
            Image(painter = painterResource(id = newsCategories.categoryImage ?: -1), contentDescription = null , modifier = modifier.fillMaxSize())
        }
    }
}