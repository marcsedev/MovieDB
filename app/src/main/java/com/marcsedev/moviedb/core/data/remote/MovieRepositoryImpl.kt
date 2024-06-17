package com.marcsedev.moviedb.core.data.remote

import com.marcsedev.moviedb.BuildConfig
import com.marcsedev.moviedb.core.data.MovieApi
import com.marcsedev.moviedb.core.data.mapper.toDomain
import com.marcsedev.moviedb.core.domain.model.Movie
import com.marcsedev.moviedb.core.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val api: MovieApi
) : MovieRepository {
    override suspend fun getUpcomingMovies(): Result<List<Movie>> {
        return try {
            val results = api.getUpcomingMovies(BuildConfig.API_KEY).results
            Result.success(results.map { it.toDomain() })
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}