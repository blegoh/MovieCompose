package com.example.moviecompose.repositories.source.remote

import com.example.moviecompose.repositories.data.ListResponse
import com.example.moviecompose.repositories.data.MovieDetail
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/3/movie/popular")
    suspend fun popularMovie(): ListResponse

    @GET("/3/movie/{id}")
    suspend fun detailMovie(
        @Path("id") id: Int
    ): MovieDetail
}