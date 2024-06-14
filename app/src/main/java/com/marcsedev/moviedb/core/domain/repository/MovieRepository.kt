package com.marcsedev.moviedb.core.domain.repository

import com.marcsedev.moviedb.core.domain.model.Movie

interface MovieRepository {
    suspend fun getUpcomingMovies(): List<Movie>
}