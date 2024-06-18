package com.example.moviecompose.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
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
import com.example.moviecompose.data.Movie

enum class MovieScreen(val title: String) {
    Home("home"), Detail("detail"), Watchlist("watchlist")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieApp(
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

    Scaffold(
        topBar = {},
        bottomBar = {
            val items = listOf(R.drawable.home, R.drawable.watchlist, R.drawable.download)
            var selectedItem by remember { mutableIntStateOf(0) }
            if (topBarVisible.value) {
                NavigationBar(
                    modifier = Modifier.height(60.dp),
                    containerColor = Color.White
                ) {
                    items.forEachIndexed { index, item ->
                        NavigationBarItem(
                            icon = {
                                Image(painter = painterResource(item), contentDescription = "")
                            },
                            selected = selectedItem == index,
                            onClick = {
                                selectedItem = index
                                when (selectedItem) {
                                    0 -> navController.navigate(MovieScreen.Home.name)
                                    1 -> navController.navigate(MovieScreen.Watchlist.name)
                                    else -> navController.navigate(MovieScreen.Home.name)
                                }
                            }
                        )
                    }
                }
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = MovieScreen.Home.title,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(route = MovieScreen.Home.name) {
                Home(onClick = {
                    navController.navigate(MovieScreen.Detail.name)
                })
            }
            composable(route = MovieScreen.Detail.name) {
                MovieDetail()
            }
            composable(route = MovieScreen.Watchlist.name) {
                Watchlist(
                    listOf(
                        Movie(""),
                        Movie(""),
                        Movie(""),
                    ),
                    onClick = {

                    }
                )
            }
        }
    }

}