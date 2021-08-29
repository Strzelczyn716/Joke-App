package com.example.jokeapp.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "joke_table", indices = [Index(value = ["id"], unique = true)])
data class Joke(
    @PrimaryKey(autoGenerate = true)
    val jokeId: Int,
    val id: Int,
    val joke: String?,
    val setup: String?,
    val delivery: String?,
    val category: String,
    val type: String,
) : Parcelable