package com.example.jokeapp.ui.joke


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jokeapp.data.model.Joke

@Composable
fun JokeScreen(
    viewModel: JokeViewModel = hiltViewModel<JokeViewModel>()
) {
    val jokes: List<Joke> by viewModel.data.observeAsState(emptyList())
    Scaffold(
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = { viewModel.add() },
                elevation = FloatingActionButtonDefaults.elevation(8.dp),
                modifier = Modifier.padding(end = 24.dp, bottom = 24.dp),
                text = { Text(text = "New joke!!!") },
            )
        },
        content = {
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
    )
}