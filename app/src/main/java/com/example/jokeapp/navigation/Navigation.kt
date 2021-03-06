package com.example.jokeapp.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jokeapp.ui.joke.JokeScreen

@ExperimentalAnimationApi
@Composable
fun Nav() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "joke_screen"
    ) {
        composable("joke_screen") {
            JokeScreen()
        }
    }
}