package com.marcsedev.moviedb.home.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun HomeMovieList(
    title: String,
    posters: List<String>,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        CategoryTitle(title = title)
        Spacer(modifier = Modifier.height(18.dp))
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(end = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(posters) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(it)
                        .crossfade(true)
                        .build(),
                    contentDescription = "poster",
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .size(
                            width = 138.dp,
                            height = 180.dp
                        ),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}


@Preview
@Composable
fun HomeMovieListPreview() {
    HomeMovieList(title = "Poster", posters = listOf())
}