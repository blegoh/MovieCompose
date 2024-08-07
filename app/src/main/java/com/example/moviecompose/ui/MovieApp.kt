package com.example.moviecompose.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.moviecompose.R
import com.example.moviecompose.repositories.data.MovieSeries
import com.example.moviecompose.ui.page.SearchPage

enum class MovieScreen(val title: String, val route: String) {
    Home("Home", "home"),
    Detail("Detail", "detail/{id}/{type}"),
    Watchlist("Watchlist", "watchlist"),
    Download("Download", "download"),
    Search("Search", "search")
}

@Composable
fun MovieApp(
    navController: NavHostController = rememberNavController()
) {
    val topBarVisible = remember { mutableStateOf(true) }
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = when (backStackEntry?.destination?.route) {
        MovieScreen.Home.route -> MovieScreen.Home
        MovieScreen.Watchlist.route -> MovieScreen.Watchlist
        MovieScreen.Download.route -> MovieScreen.Download
        MovieScreen.Search.route -> MovieScreen.Search
        else -> MovieScreen.Detail
    }

    LaunchedEffect(navController) {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            topBarVisible.value = when (destination.route) {
                MovieScreen.Home.route -> true
                MovieScreen.Watchlist.route -> true
                MovieScreen.Download.route -> true
                MovieScreen.Search.route -> true
                else -> false
            }
        }
    }

    Scaffold(topBar = {
        MovieAppBar(
            currentScreen = currentScreen, onSearch = {
                navController.navigate(MovieScreen.Search.name)
            }
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
            composable(route = MovieScreen.Home.route) {
                Home(onClick = { id, type ->
                    navController.navigate(
                        MovieScreen.Detail.route.replace("{id}", id.toString())
                            .replace("{type}", type.toString())
                    )
                })
            }
            composable(route = MovieScreen.Detail.route, arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                }, navArgument("type") {
                    type = NavType.IntType
                }
            )) {
                val id = backStackEntry?.arguments?.getInt("id") ?: 0
                val type = backStackEntry?.arguments?.getInt("type") ?: 1

                DetailScreen(id, type) {
                    navController.popBackStack()
                }
            }
            composable(route = MovieScreen.Watchlist.route) {
                Watchlist(listOf(
                    MovieSeries(1, "", "", 1)
                ), onClick = {
//                    navController.navigate(MovieScreen.Detail.name)
                })
            }
            composable(route = MovieScreen.Download.route) {
                Download(listOf(
                    MovieSeries(1, "", "", 1)
                ), onClick = {
//                    navController.navigate(MovieScreen.Detail.name)
                })
            }
            composable(route = MovieScreen.Search.route) {
                SearchPage()
            }
        }
    }

}