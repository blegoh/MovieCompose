package com.example.moviecompose.view

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

enum class MovieScreen(val title: String) {
    Home("home"), Detail("detail")
}

@Composable
fun MovieApp(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = MovieScreen.Home.title,
    ) {
        composable(route = MovieScreen.Home.name) {
            Home(onClick = {
                navController.navigate(MovieScreen.Detail.name)
            })
        }
        composable(route = MovieScreen.Detail.name) {
            MovieDetail()
        }
    }
}