package com.example.jokeapp.di

import com.example.jokeapp.api.JokeApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object JokeModule {

    @Singleton
    @Provides
    fun provideJokeApi(): JokeApi = Retrofit.Builder()
        .baseUrl(JokeApi.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(JokeApi::class.java)
}