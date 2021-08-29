package com.example.jokeapp.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.jokeapp.data.model.Joke

@Database(
    entities = [Joke::class],
    version = 1,
    exportSchema = false
)
abstract class JokeDatabase : RoomDatabase() {

    abstract fun jokeDao(): JokeDao

    companion object {
        private const val DB_NAME: String = "joke_database"

        @Volatile
        private var INSTANCE: JokeDatabase? = null
        fun getDatabase(context: Context): JokeDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    JokeDatabase::class.java,
                    DB_NAME
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}