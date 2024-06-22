package com.example.moviecompose.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.moviecompose.R
import com.example.moviecompose.repositories.data.Movie
import com.example.moviecompose.viewmodels.HomeViewModel

enum class MovieScreen(val title: String) {
    Home("Home"), Detail("Detail"), Watchlist("Watchlist"), Download("Download")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieApp(
    viewModel: HomeViewModel,
    navController: NavHostController = rememberNavController()
) {
    val topBarVisible = remember { mutableStateOf(true) }
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = MovieScreen.valueOf(
        backStackEntry?.destination?.route ?: MovieScreen.Home.name
    )

    LaunchedEffect(navController) {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            topBarVisible.value = when (destination.route) {
                MovieScreen.Home.name -> true
                MovieScreen.Watchlist.name -> true
                else -> false
            }
        }
    }

    Scaffold(topBar = {
        MovieAppBar(
            currentScreen = currentScreen
        )
    }, bottomBar = {
        val items = listOf(
            Pair(R.drawable.home, R.drawable.home_filled),
            Pair(R.drawable.watchlist, R.drawable.watchlist_filled),
            Pair(R.drawable.download, R.drawable.download_filled),
        )
        var selectedItem by remember { mutableIntStateOf(0) }
        if (topBarVisible.value) {
            NavigationBar(
                modifier = Modifier.height(60.dp), containerColor = Color.White
            ) {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(icon = {
                        Image(
                            painter = if (selectedItem == index)
                                painterResource(item.second)
                            else
                                painterResource(item.first),
                            contentDescription = ""
                        )
                    }, colors = NavigationBarItemDefaults.colors(
                        indicatorColor = Color.White,
                    ), selected = selectedItem == index, onClick = {
                        selectedItem = index
                        when (selectedItem) {
                            0 -> navController.navigate(MovieScreen.Home.name)
                            1 -> navController.navigate(MovieScreen.Watchlist.name)
                            2 -> navController.navigate(MovieScreen.Download.name)
                            else -> navController.navigate(MovieScreen.Home.name)
                        }
                    })
                }
            }
        }
    }) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = MovieScreen.Home.title,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(route = MovieScreen.Home.name) {
                Home(viewModel, onClick = {
                    navController.navigate(MovieScreen.Detail.name)
                })
            }
            composable(route = MovieScreen.Detail.name) {
                MovieDetail {
                    navController.popBackStack()
                }
            }
            composable(route = MovieScreen.Watchlist.name) {
                Watchlist(listOf(
                    Movie(""),
                    Movie(""),
                    Movie(""),
                    Movie(""),
                    Movie(""),
                    Movie(""),
                    Movie(""),
                    Movie(""),
                    Movie(""),
                    Movie(""),
                    Movie(""),
                ), onClick = {
                    navController.navigate(MovieScreen.Detail.name)
                })
            }
            composable(route = MovieScreen.Download.name) {
                Download(listOf(
                    Movie(""),
                    Movie(""),
                    Movie(""),
                    Movie(""),
                    Movie(""),
                    Movie(""),
                    Movie(""),
                    Movie(""),
                    Movie(""),
                    Movie(""),
                    Movie(""),
                ), onClick = {
                    navController.navigate(MovieScreen.Detail.name)
                })
            }
        }
    }

}