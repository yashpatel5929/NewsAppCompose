package com.example.newsapp.navigation

import android.opengl.Visibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.newsapp.R
import com.example.newsapp.component.TopBar
import com.example.newsapp.domain.model.BottomNavData
import com.example.newsapp.presentation.ui.component.BottomNavigationTab
import com.example.newsapp.presentation.ui.home.HomeScreen
import com.example.newsapp.presentation.ui.home.HomeScreenViewModel
import com.example.newsapp.presentation.ui.onboarding.OnBoardingScreen
import com.example.newsapp.presentation.ui.onboarding.OnBoardingViewModel
import com.example.newsapp.presentation.ui.search.SearchScreen
import com.example.newsapp.presentation.ui.trending.TrendingScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SetUpNavigation(
    navController: NavHostController = rememberNavController()
) {

    val backStackEntry by navController.currentBackStackEntryAsState()

    val currentDestination = backStackEntry?.destination
    val currentScreens =
        NewAppDestinationList.find { it.route == currentDestination?.route } ?: OnBoarding
    val bottomTabData = listOf<BottomNavData>(
        BottomNavData(image = R.drawable.baseline_home, "Home", HomeScreen.route),
        BottomNavData(
            image = R.drawable.baseline_local_fire_department_24,
            "Trending",
            TrendingScreen.route
        ),
        BottomNavData(image = R.drawable.baseline_search, "Search", SearchScreen.route),
    )

    Scaffold(
        modifier = Modifier.background(Color.Transparent),
        bottomBar = {
            if(currentDestination?.route != OnBoarding.route) {
                BottomNavigationTab(
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.background), bottomTabDataList = bottomTabData,
                    currentScreen = currentScreens
                ) {
                    navController.navigateSingleTopTo(it)
                }
            }
        }
    ) { innerPadding ->

        NavHost(
            navController = navController, startDestination = OnBoarding.route,
            modifier = Modifier.padding()
        ) {


            composable(
                route = OnBoarding.route
            ) {
                val viewModel = hiltViewModel<OnBoardingViewModel>()
                OnBoardingScreen(viewModel = viewModel) {
                    navController.navigate(HomeScreen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            inclusive = true
                        }
                    }
                }
            }

            composable(
                route = HomeScreen.route
            ) {
                val viewModel = hiltViewModel<HomeScreenViewModel>()
                HomeScreen(viewModel = viewModel)
            }

            composable(
                route = TrendingScreen.route
            ) {
                TrendingScreen()
            }

            composable(
                route = SearchScreen.route
            ) {
                SearchScreen()
            }
            /*  homeScreenGraph(navController)
              bookMarkGraph(navController)*/
        }

    }

}