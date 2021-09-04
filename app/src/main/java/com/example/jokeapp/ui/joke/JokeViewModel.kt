package com.example.jokeapp.ui.joke

import androidx.lifecycle.MutableLiveData
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
    private val _progress = MutableLiveData(false)
    val progress get() = _progress

    fun add() {
        if (progress.value == true) {
            return
        }
        CoroutineScope(IO).launch {
            _progress.postValue(true)
            val joke = jokeApi.getJoke()
            delay(2000)
            repository.jokeAdd(joke)
            _progress.postValue(false)
        }
    }
}