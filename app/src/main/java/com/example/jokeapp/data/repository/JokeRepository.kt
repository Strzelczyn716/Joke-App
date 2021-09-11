package com.example.jokeapp.data.repository

import androidx.paging.PagingSource
import com.example.jokeapp.data.db.JokeDao
import com.example.jokeapp.data.model.Joke

class JokeRepository(private val jokeDao: JokeDao) {

    suspend fun jokeAdd(joke: Joke) {
        jokeDao.jokeAdd(joke)
    }

    fun readAllData(): PagingSource<Int, Joke> {
        return jokeDao.readAllData()
    }
}