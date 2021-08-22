package com.example.jokeapp.api

import com.example.jokeapp.data.model.Joke
import retrofit2.http.GET

interface JokeApi {

    companion object{
       const val BASE_URL = "https://v2.jokeapi.dev/joke/"
    }

    @GET("any")
    suspend fun getJoke() :Joke
}