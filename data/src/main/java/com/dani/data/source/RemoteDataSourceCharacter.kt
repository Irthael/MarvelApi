package com.dani.data.source

import com.dani.domain.Mycharacter

interface RemoteDataSource {
    suspend fun getCharacterList(offset: Int): List<Mycharacter>
    suspend fun getCharacterInfo(characterID: Int): Mycharacter
}