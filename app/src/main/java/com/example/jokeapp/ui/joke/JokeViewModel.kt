package com.example.jokeapp.ui.joke

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.jokeapp.R
import com.example.jokeapp.api.JokeApi
import com.example.jokeapp.data.repository.JokeRepository
import com.example.jokeapp.network.NetworkState
import dagger.hilt.android.lifecycle.HiltViewModel
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
    val networkState: NetworkState,
    @ApplicationContext private val context: Context
) : ViewModel() {

    companion object {
        const val TIME_FOR_ANSWER = 2000L
    }

    val data get() = Pager(
        config = PagingConfig(
            pageSize = 20,
            enablePlaceholders = false
        ),
        pagingSourceFactory = {  repository.readAllData() }
    ).flow
    private val _progress = MutableLiveData(false)
    val progress get() = _progress
    private val _errorHandler = MutableLiveData("")
    val errorHandler get() = _errorHandler

    fun add() {
        _errorHandler.postValue("")
        if (progress.value == true) {
            return
        }
        if (networkState.value == false){
            _errorHandler.postValue(context.getString(R.string.error_connection))
            return
        }
        CoroutineScope(IO).launch {
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