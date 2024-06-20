package com.marcsedev.moviedb.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.marcsedev.moviedb.home.presentation.HomeScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AppScreens.HomeScreen.route,
    ) {
        composable(AppScreens.HomeScreen.route) {
            HomeScreen()
        }
    }
}