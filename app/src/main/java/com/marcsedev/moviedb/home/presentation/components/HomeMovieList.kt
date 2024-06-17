package com.marcsedev.moviedb.home.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun HomeMovieList(
    title: String,
    posters: List<String>,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(text = title, fontWeight = FontWeight.SemiBold, fontSize = 20.sp, color = Color.White)
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(end = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(posters) {
                AsyncImage(
                    model = it,
                    contentDescription = "poster",
                    modifier = Modifier.size(width = 138.dp, height = 180.dp),
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