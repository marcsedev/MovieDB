package com.marcsedev.moviedb.home.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.unit.dp
import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.marcsedev.moviedb.home.presentation.components.HomeMovieList

@SuppressLint("SuspiciousIndentation")
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state = viewModel.state

    LazyColumn(
        modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item { CustomText() }
        item { Spacer(modifier = Modifier.height(16.dp)) }
        if (state.upcoming.isNotEmpty()) {
            item {
                HomeMovieList(
                    title = "Próximos estrenos",
                    posters = state.upcoming.map { it.poster }
                )
            }
        }
        item { Spacer(modifier = Modifier.height(16.dp)) }
        if (state.upcoming.isNotEmpty()) {
            item {
                HomeMovieList(
                    title = "Recomendads para ti",
                    posters = state.upcoming.map { it.poster }
                )
            }
        }
    }
    if (state.isLoading) {
        Box(modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator(
                modifier = Modifier
                    .align(Alignment.Center)
            )
        }
    }
}

@Composable
fun CustomText() {
    Box(
        modifier = Modifier
            .border(
                BorderStroke(width = 2.dp, color = Color.White),
            )
    ) {
        Text(
            text = "eMovie",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(4.dp), // Espaciado interno
            textAlign = TextAlign.Center
        )
    }
}