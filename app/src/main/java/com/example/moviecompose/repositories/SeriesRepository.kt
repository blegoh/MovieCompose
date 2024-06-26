package com.example.moviecompose.repositories

import com.example.moviecompose.repositories.source.remote.ApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SeriesRepository @Inject constructor(
    private val remote: ApiService
) {
    suspend fun getPopularSeries() = remote.popularSeries()

    suspend fun getSeriesDetail(id: Int) = remote.detailSeries(id)

    suspend fun getSeasonDetail(idSeries: Int, season: Int) = remote.detailSeason(idSeries, season)
}