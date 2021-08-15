package com.example.jokeapp.data.model

data class Joke(
    val id: Int,
    val joke: String,
    val setup: String,
    val delivery: String,
    val category: String,
    val type: String,
)