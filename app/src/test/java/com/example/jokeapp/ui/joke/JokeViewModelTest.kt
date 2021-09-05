package com.example.jokeapp.ui.joke


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.jokeapp.api.JokeApi
import com.example.jokeapp.data.model.Joke
import com.example.jokeapp.data.repository.JokeRepository
import com.google.common.truth.Truth.assertThat
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test

class JokeViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val sampleJoke = Joke(
        1,
        277,
        null,
        "\"99.9% of the people are dumb!\"",
        "\"Fortunately I belong to the remaining 1%\"",
        "Misc",
        "twopart"
    )

    @Test
    fun addTest() {
        runBlocking {
            //given
            val api = mockk<JokeApi>()
            val repository = mockk<JokeRepository>()
            val viewModel = JokeViewModel(api, repository, mockk())
            coEvery { api.getJoke() } returns sampleJoke
            coEvery { repository.jokeAdd(any<Joke>()) } returns mockk()
            //when
            viewModel.add()
            delay(3000)
            //then
            assertThat(viewModel.progress.value).isEqualTo(false)
            assertThat(viewModel.errorHandler.value).isEqualTo("")
        }
    }
}