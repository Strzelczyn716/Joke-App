package com.example.jokeapp.ui.joke


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jokeapp.data.model.Joke

@Composable
fun JokeScreen(
    viewModel: JokeViewModel = hiltViewModel<JokeViewModel>()
) {
    viewModel.add()
    val jokes :List<Joke> by viewModel.data.observeAsState(emptyList())

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