package com.dani.data.repository

import com.dani.data.source.LocalDataSource
import com.dani.data.source.RemoteDataSource
import com.dani.domain.Mycharacter

class CharacterRepository(private val localDataSourceCharacters: LocalDataSource,
                          private val remoteDataSourceCharacters: RemoteDataSource
){

    suspend fun getCharactersList(offset: Int): List<Mycharacter> {

        val characterList = remoteDataSourceCharacters.getCharacterList(offset)
        localDataSourceCharacters.saveCharacters(characterList)

        return localDataSourceCharacters.getCharacters()
    }

    suspend fun getCharactersListFilter(offset: Int, name: String): List<Mycharacter> {

        val characterList = remoteDataSourceCharacters.getCharacterFilterList(offset, name)
        localDataSourceCharacters.saveCharacters(characterList)

        return localDataSourceCharacters.getCharactersByName(name)
    }

    suspend fun findCharacterById(characterID: Int): Mycharacter =
        localDataSourceCharacters.findCharacterById(characterID)

    suspend fun findCharacterByIdInServer(characterId: Int): Mycharacter =
        remoteDataSourceCharacters.getCharacterInfo(characterId)
}

