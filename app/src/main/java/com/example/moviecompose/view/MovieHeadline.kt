package com.example.moviecompose.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.moviecompose.data.Movie
import com.example.moviecompose.theme.MovieComposeTheme
import com.example.moviecompose.view.items.MovieCard

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MovieHeadline(movies: List<Movie>) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        val pagerState = rememberPagerState { movies.size }

        HorizontalPager(state = pagerState) { page ->
            MovieCard()
        }
        DotsIndicator(
            totalDots = 3,
            selectedIndex = pagerState.currentPage,
            selectedColor = Color.Black,
            unSelectedColor = Color.Gray,
        )
        Spacer(modifier = Modifier.padding(4.dp))
    }
}

@Composable
fun DotsIndicator(
    totalDots: Int,
    selectedIndex: Int,
    selectedColor: Color,
    unSelectedColor: Color,
) {

    LazyRow(
        modifier = Modifier
            .wrapContentWidth()
            .wrapContentHeight()
    ) {

        items(totalDots) { index ->
            if (index == selectedIndex) {
                Box(
                    modifier = Modifier
                        .size(5.dp)
                        .clip(CircleShape)
                        .background(selectedColor)
                )
            } else {
                Box(
                    modifier = Modifier
                        .size(5.dp)
                        .clip(CircleShape)
                        .background(unSelectedColor)
                )
            }

            if (index != totalDots - 1) {
                Spacer(modifier = Modifier.padding(horizontal = 2.dp))
            }
        }
    }
}

@Preview()
@Composable
fun PreviewMovieHeadline() {
    MovieComposeTheme() {
        MovieHeadline(
            listOf(
                Movie(""),
                Movie(""),
                Movie(""),
            )
        )
    }
}