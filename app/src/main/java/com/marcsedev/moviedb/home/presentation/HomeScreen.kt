package com.marcsedev.moviedb.home.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.marcsedev.moviedb.R
import com.marcsedev.moviedb.home.presentation.components.CustomTitleHomeText
import com.marcsedev.moviedb.home.presentation.components.FilteredButton
import com.marcsedev.moviedb.home.presentation.components.HomeMovieList
import com.marcsedev.moviedb.ui.theme.Background

@SuppressLint("SuspiciousIndentation")
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val state = viewModel.state
    val (isSelected, setIsSelected) = remember { mutableStateOf(false) }

    Scaffold(
        containerColor = Background,
        content = { paddingValues ->
            Box(modifier = Modifier.padding(paddingValues)) {
                LazyColumn(
                    modifier = Modifier
                        .padding(horizontal = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center

                ) {
                    item {
                        CustomTitleHomeText()
                    }
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
                    if (state.popular.isNotEmpty()) {
                        item {
                            HomeMovieList(
                                title = "Tendencias",
                                posters = state.popular.map { it.poster }
                            )
                        }
                    }
                    item { Spacer(modifier = Modifier.height(27.dp)) }
                    item {
                        LazyRow(
                            horizontalArrangement = Arrangement.Start,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            item {
                                FilteredButton(
                                    text = "En Español",
                                    isSelected = isSelected,
                                    onClick = { setIsSelected(!isSelected) }
                                )
                            }
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
        }
    )
}