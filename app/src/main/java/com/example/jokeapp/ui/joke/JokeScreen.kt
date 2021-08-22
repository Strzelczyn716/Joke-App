package com.example.jokeapp.ui.joke


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun JokeScreen(
    viewModel: JokeViewModel = hiltViewModel<JokeViewModel>()
) {
    viewModel.add()
    val jokes = remember { viewModel.data }

    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(
            items = jokes,
            itemContent = {
                JokeListItem(joke = it)
            })
    }
}