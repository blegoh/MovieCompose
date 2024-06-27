package com.example.moviecompose.repositories.source.remote

import com.example.moviecompose.repositories.data.ListResponse
import com.example.moviecompose.repositories.data.Movie
import com.example.moviecompose.repositories.data.MovieDetail
import com.example.moviecompose.repositories.data.Series
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/3/movie/popular")
    suspend fun popularMovie(): ListResponse<Movie>

    @GET("/3/tv/popular")
    suspend fun popularSeries(): ListResponse<Series>

    @GET("/3/movie/{id}")
    suspend fun detailMovie(
        @Path("id") id: Int
    ): MovieDetail
}