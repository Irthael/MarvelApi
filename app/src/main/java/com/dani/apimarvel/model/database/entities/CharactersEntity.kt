package com.dani.apimarvel.model.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dani.domain.*

@Entity
data class CharactersEntity(
    @PrimaryKey (autoGenerate = false)
    val id: Int,
    val name: String,
    val description: String,
    val resourceURI: String,
    val urls: List<Url>,
    val thumbnail: Image
)
