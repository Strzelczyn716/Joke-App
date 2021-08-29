package com.example.jokeapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.jokeapp.data.model.Joke
import kotlinx.coroutines.flow.Flow

@Dao
interface JokeDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun jokeAdd(joke: Joke)

    @Query("SELECT * FROM joke_table ORDER BY id DESC")
    fun readAllData(): Flow<List<Joke>>

}