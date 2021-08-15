package com.example.jokeapp.ui.joke


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun JokeScreen(
    helloViewModel: JokeViewModel = JokeViewModel()
) {
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize()
    ) {
    }
}