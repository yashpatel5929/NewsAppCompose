package com.example.newsapp.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.newsapp.presentation.ui.home.HomeScreen
import com.example.newsapp.presentation.ui.home.HomeScreenViewModel


/*
fun NavGraphBuilder.homeScreenGraph(
    navController: NavController
) {

    navigation(
        startDestination = Screens.HomeScreen.name,
        route = NavGraph.HOME.name
    ){
        composable(route = Screens.HomeScreen.name) {
            val viewModel = hiltViewModel<HomeScreenViewModel>()
             HomeScreen(viewModel = viewModel, Modifier)
        }
    }

}*/
