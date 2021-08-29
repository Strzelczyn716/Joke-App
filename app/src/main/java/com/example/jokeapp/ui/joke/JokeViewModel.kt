package com.example.jokeapp.ui.joke

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.jokeapp.api.JokeApi
import com.example.jokeapp.data.repository.JokeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class JokeViewModel @Inject constructor(
    private val jokeApi: JokeApi,
    private val repository: JokeRepository
) : ViewModel() {

    val data get() = repository.readAllData().asLiveData()

    fun add() {
        CoroutineScope(IO).launch {
            val joke = jokeApi.getJoke()
            delay(2000)
            repository.jokeAdd(joke)
        }
    }
}