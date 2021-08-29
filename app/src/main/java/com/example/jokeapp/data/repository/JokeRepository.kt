package com.example.jokeapp.data.repository

import com.example.jokeapp.data.db.JokeDao
import com.example.jokeapp.data.model.Joke
import kotlinx.coroutines.flow.Flow

class JokeRepository(private val jokeDao: JokeDao) {

    suspend fun jokeAdd(joke: Joke) {
        jokeDao.jokeAdd(joke)
    }

    fun readAllData(): Flow<List<Joke>> {
        return jokeDao.readAllData()
    }
}