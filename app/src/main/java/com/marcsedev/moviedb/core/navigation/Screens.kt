package com.marcsedev.moviedb.core.navigation


sealed class AppScreens(val route: String) {

    data object HomeScreen: AppScreens("home_screen")
    data object SplashScreen: AppScreens("splash_screen")


}