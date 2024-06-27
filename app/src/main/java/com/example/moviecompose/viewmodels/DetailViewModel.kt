package com.example.moviecompose.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviecompose.repositories.MovieRepository
import com.example.moviecompose.repositories.data.MovieDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {

    private val _movie: MutableLiveData<MovieDetail> = MutableLiveData()
    val movie: LiveData<MovieDetail> = _movie
    fun getMovie(id: Int) = viewModelScope.launch {
        try {
            _movie.value = movieRepository.getMovieDetail(id)
        } catch (e: Exception) {
            // Handle errors here
        }
    }
}