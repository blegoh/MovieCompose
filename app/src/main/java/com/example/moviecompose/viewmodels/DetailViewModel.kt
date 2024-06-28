package com.example.moviecompose.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviecompose.repositories.MovieRepository
import com.example.moviecompose.repositories.SeriesRepository
import com.example.moviecompose.repositories.data.MovieDetail
import com.example.moviecompose.repositories.data.SeriesDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val movieRepository: MovieRepository,
    private val seriesRepository: SeriesRepository
) : ViewModel() {

    private val _movie: MutableLiveData<MovieDetail> = MutableLiveData()
    private val _series: MutableLiveData<SeriesDetail> = MutableLiveData()

    val movie: LiveData<MovieDetail> = _movie
    val series: LiveData<SeriesDetail> = _series

    fun getMovie(id: Int) = viewModelScope.launch {
        try {
            _movie.value = movieRepository.getMovieDetail(id)
        } catch (e: Exception) {
            // Handle errors here
        }
    }

    fun getSeries(id: Int) = viewModelScope.launch {
        try {
            _series.value = seriesRepository.getSeriesDetail(id)
        } catch (e: Exception) {
            // Handle errors here
        }
    }
}