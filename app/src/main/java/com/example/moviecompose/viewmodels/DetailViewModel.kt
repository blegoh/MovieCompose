package com.example.moviecompose.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviecompose.repositories.MovieRepository
import com.example.moviecompose.repositories.data.Movie
import com.example.moviecompose.repositories.data.MovieDetail
import com.example.moviecompose.repositories.data.MovieSeries
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {

    val movie: MutableState<MovieDetail?> = mutableStateOf(null)
    fun getMovie(id: Int) = viewModelScope.launch {
        try {
            movie.value = movieRepository.getMovieDetail(id)
        } catch (e: Exception) {
            // Handle errors here
        }
    }
}