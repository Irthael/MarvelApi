package com.dani.marvelapi.model.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UrlEntity(
    @PrimaryKey (autoGenerate = false)
    val id: Int,
    val type: String,
    val url: String
)
