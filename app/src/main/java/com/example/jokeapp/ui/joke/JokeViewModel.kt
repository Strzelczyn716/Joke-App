package com.example.jokeapp.ui.joke

import androidx.lifecycle.ViewModel
import com.example.jokeapp.api.JokeApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class JokeViewModel @Inject constructor(
    private val jokeApi: JokeApi,
) : ViewModel() {

    val data = DataProvider.jokeList

    fun add() {
        CoroutineScope(IO).launch {
            val data1 = jokeApi.getJoke()
            delay(2000)
            data.add(data1)
        }
    }
}