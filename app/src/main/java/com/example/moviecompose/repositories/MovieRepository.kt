package com.example.moviecompose.repositories

import com.example.moviecompose.repositories.source.remote.ApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(
    private val remote: ApiService
) {

    suspend fun getPopularMovie() = remote.popularMovie()

    suspend fun getMovieDetail(id: Int) = remote.detailMovie(id)
}