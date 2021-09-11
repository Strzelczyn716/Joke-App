package com.example.jokeapp.ui.joke


import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.jokeapp.data.model.Joke


@ExperimentalAnimationApi
@Composable
fun JokeScreen(
    viewModel: JokeViewModel = hiltViewModel<JokeViewModel>()
) {
    val jokes = remember {viewModel.data}
    val lazyPagingItems = jokes.collectAsLazyPagingItems()
    val progress: Boolean by viewModel.progress.observeAsState(false)
    val networkState: Boolean by viewModel.networkState.observeAsState(false)
    val error: String by viewModel.errorHandler.observeAsState("")
    val context = LocalContext.current
    Scaffold(
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = { viewModel.add() },
                elevation = FloatingActionButtonDefaults.elevation(8.dp),
                modifier = Modifier.padding(end = 24.dp, bottom = 48.dp),
                text = { Text(text = "New joke!!!") },
            )
        },
        content = {
            LazyColumn(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
            ) {
                items(
                    items = lazyPagingItems.snapshot(),
                    itemContent = {
                        it?.let { it1 -> JokeListItem(joke = it1) }
                    })
            }
            AnimatedVisibility(
                visible = progress,
                enter = slideInVertically(),
                exit = slideOutVertically()
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    CircularProgressIndicator()
                }
            }
            if(error.isNotBlank()) {
                Toast.makeText(context, error, Toast.LENGTH_LONG).show()
            }
        }
    )
}