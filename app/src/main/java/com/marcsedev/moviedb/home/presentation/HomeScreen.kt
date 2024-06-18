package com.marcsedev.moviedb.home.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.marcsedev.moviedb.R
import com.marcsedev.moviedb.home.presentation.components.CustomTitleHomeText
import com.marcsedev.moviedb.home.presentation.components.HomeMovieList

@SuppressLint("SuspiciousIndentation")
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state = viewModel.state

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item { CustomTitleHomeText() }
        item { Spacer(modifier = Modifier.height(27.dp)) }
        if (state.upcoming.isNotEmpty()) {
            item {
                HomeMovieList(
                    title = stringResource(R.string.upcoming_releases),
                    posters = state.upcoming.map { it.poster }
                )
            }
        }
        item { Spacer(modifier = Modifier.height(27.dp)) }
        if (state.upcoming.isNotEmpty()) {
            item {
                HomeMovieList(
                    title = "Tendencias",
                    posters = state.popular.map { it.poster }
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