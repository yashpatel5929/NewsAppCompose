package com.example.newsapp.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import com.example.newsapp.R

enum class Screens (val screenName : String) {
    OnBoardingScreen("OnBoarding"),
    HomeScreen("Home"),
    Search("Search"),
    Trending("Trending")
}

interface NewsAppDestination {
    val icon : Int?
    val route : String
}

object HomeScreen : NewsAppDestination {
    override val icon: Int = R.drawable.baseline_home
    override val route: String = Screens.HomeScreen.screenName
}

object TrendingScreen : NewsAppDestination {
    override val icon: Int = R.drawable.baseline_local_fire_department_24
    override val route: String = Screens.Trending.screenName
}

object SearchScreen : NewsAppDestination {
    override val icon: Int = R.drawable.baseline_search
    override val route: String = Screens.Search.screenName
}

object  OnBoarding : NewsAppDestination {
    override val icon: Int? = null
    override val route: String = Screens.OnBoardingScreen.screenName

}

val NewAppDestinationList = listOf(HomeScreen , TrendingScreen , SearchScreen , OnBoarding)