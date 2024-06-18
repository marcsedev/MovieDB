package com.marcsedev.moviedb.core.data.mapper

import com.marcsedev.moviedb.core.data.MovieApi
import com.marcsedev.moviedb.core.data.remote.dto.MovieResult
import com.marcsedev.moviedb.core.domain.model.Movie

fun MovieResult.toDomain(): Movie {
    return Movie(
        description = this.overview ?: "",
        title = this.title,
        releaseYear = this.releaseDate?.substring(0, 4)?.toIntOrNull() ?: 0,
        language = this.originalLanguage ?: "",
        rating = this.voteAverage,
        poster = MovieApi.IMAGE_URL + (this.posterPath ?: ""),
        genres = this.genreIds ?: emptyList() // Utiliza una lista vacía si genreIds es nulo
    )
}
