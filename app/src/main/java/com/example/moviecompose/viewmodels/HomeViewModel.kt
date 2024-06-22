package com.example.moviecompose.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviecompose.repositories.MovieRepository
import com.example.moviecompose.repositories.data.Movie
import com.example.moviecompose.repositories.data.MovieSeries
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {

    val movies: MutableState<List<MovieSeries>> = mutableStateOf(emptyList())
    fun getMovies() = viewModelScope.launch {
        try {
            val response = movieRepository.getPopularMovie()
            if (response.results?.isNotEmpty() == true) {
                movies.value = response.results
            }
        } catch (e: Exception) {
            // Handle errors here
        }
    }
}