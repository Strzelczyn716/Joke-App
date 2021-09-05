package com.example.jokeapp.ui.joke

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.jokeapp.R
import com.example.jokeapp.api.JokeApi
import com.example.jokeapp.data.repository.JokeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class JokeViewModel @Inject constructor(
    private val jokeApi: JokeApi,
    private val repository: JokeRepository,
    @ApplicationContext private val context: Context
) : ViewModel() {

    companion object {
        const val TIME_FOR_ANSWER = 2000L
    }

    val data get() = repository.readAllData().asLiveData()
    private val _progress = MutableLiveData(false)
    val progress get() = _progress
    private val _errorHandler = MutableLiveData("")
    val errorHandler get() = _errorHandler

    fun add() {
        if (progress.value == true) {
            return
        }
        CoroutineScope(IO).launch {
            _errorHandler.postValue("")
            _progress.postValue(true)
            try {
                val joke = jokeApi.getJoke()
                delay(TIME_FOR_ANSWER)
                repository.jokeAdd(joke)
            }catch (e: Exception){
                _errorHandler.postValue(context.getString(R.string.error_message))
            }
            _progress.postValue(false)
        }
    }
}