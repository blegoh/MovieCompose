package com.example.moviecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.moviecompose.theme.MovieComposeTheme
import com.example.moviecompose.ui.MovieApp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieComposeTheme(
                darkTheme = false
            ) {
                MovieApp()
            }
        }
    }


}