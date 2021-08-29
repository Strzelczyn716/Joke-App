package com.example.jokeapp.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "joke_table")
data class Joke(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val joke: String,
    val setup: String,
    val delivery: String,
    val category: String,
    val type: String,
) : Parcelable