package com.example.moviecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import com.example.moviecompose.data.Movie
import com.example.moviecompose.theme.MovieComposeTheme
import com.example.moviecompose.view.ContinueWatching
import com.example.moviecompose.view.Home
import com.example.moviecompose.view.MovieCard
import com.example.moviecompose.view.MovieDetail
import com.example.moviecompose.view.MovieHeadline
import com.example.moviecompose.view.PopularMovie


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieComposeTheme {
                MovieDetail()
            }
        }
    }


}