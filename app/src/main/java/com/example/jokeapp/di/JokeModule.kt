package com.example.jokeapp.di

import android.content.Context
import com.example.jokeapp.api.JokeApi
import com.example.jokeapp.data.db.JokeDatabase
import com.example.jokeapp.data.repository.JokeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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

    @Singleton
    @Provides
    fun provideRepository(@ApplicationContext context: Context) = JokeRepository(JokeDatabase.getDatabase(context).jokeDao())

}