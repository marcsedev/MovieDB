package com.marcsedev.moviedb.home.presentation

import com.marcsedev.moviedb.core.domain.model.Movie
data class HomeState(
    val upcoming: List<Movie> = emptyList(),
    val isLoading: Boolean = false
) {
}