package com.example.newsapp.presentation.ui.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.newsapp.domain.model.BottomNavData
import com.example.newsapp.navigation.NewsAppDestination
import com.example.newsapp.ui.theme.primaryLight

@Composable
fun BottomNavigationTab(
    modifier: Modifier = Modifier,
    bottomTabDataList: List<BottomNavData>,
    currentScreen: NewsAppDestination,
    tabItemClick: (String) -> Unit
) {

    Row (modifier.padding(bottom = 25.dp , start = 20.dp , end = 20.dp).clip(shape = RoundedCornerShape(50.dp)).background(color = Color.White).fillMaxWidth() , verticalAlignment = Alignment.Bottom , horizontalArrangement = Arrangement.SpaceBetween) {
        bottomTabDataList.forEach {
            TabLayout(tabIcon = it.image , tabTitle = it.tabName , route = it.navigateTo , isSelected = currentScreen.route == it.navigateTo ) {
                tabItemClick(it)
            }
        }
    }
}

@Composable
fun TabLayout(modifier: Modifier = Modifier , @DrawableRes tabIcon : Int , tabTitle : String , route : String , isSelected : Boolean, itemClick : (String) -> Unit) {
    Column(modifier = modifier.padding(15.dp).clickable {
          itemClick(route)
    } , horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(painter = painterResource(id = tabIcon), contentDescription = null , tint = if(isSelected) MaterialTheme.colorScheme.primary else Color.Black)
        Text(text = tabTitle , style = MaterialTheme.typography.titleSmall , color = if(isSelected)  MaterialTheme.colorScheme.primary else Color.Black)
    }
}