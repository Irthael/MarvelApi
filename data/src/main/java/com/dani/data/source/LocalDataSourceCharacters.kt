package com.dani.data.source

import com.dani.domain.Mycharacter

interface LocalDataSource {
    suspend fun saveCharacters(list: List<Mycharacter>)
    suspend fun getCharacters(): List<Mycharacter>
    suspend fun getCharactersByName(name: String): List<Mycharacter>
    suspend fun updateCharacter(characterID: Mycharacter)
    suspend fun findCharacterById(characterID: Int): Mycharacter
}


