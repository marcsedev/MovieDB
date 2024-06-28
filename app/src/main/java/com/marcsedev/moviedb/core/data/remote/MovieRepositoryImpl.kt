package com.marcsedev.moviedb.core.data.remote

import com.marcsedev.moviedb.core.data.MovieApi
import com.marcsedev.moviedb.core.data.mapper.toDomain
import com.marcsedev.moviedb.core.domain.model.Movie
import com.marcsedev.moviedb.core.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val api: MovieApi
) : MovieRepository {
    override suspend fun getUpcomingMovies(): Result<List<Movie>> {
        return try {
            val results = api.getUpcomingMovies(/*BuildConfig.API_KEY*/).results
            Result.success(results.map { it.toDomain() })
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getPopularMovies(): Result<List<Movie>> {
        return try {
            val results = api.getPopularMovies().results
            Result.success(results.map { it.toDomain() })
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getMoviesByYear(year: Int): Result<List<Movie>> {
        return try {
            val results = api.getMoviesByYear(year).results
            Result.success(results.map { it.toDomain() })
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getMoviesByLanguage(language: String): Result<List<Movie>> {
        return try {
            val results = api.getMoviesByLanguage(language).results
            Result.success(results.map { it.toDomain() })
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}