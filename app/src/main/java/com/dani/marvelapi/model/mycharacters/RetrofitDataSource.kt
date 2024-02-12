package com.dani.marvelapi.model.mycharacters

import com.dani.marvelapi.model.APIServiceManager
import com.dani.data.source.RemoteDataSource
import com.dani.domain.Mycharacter as CharactersDomain

class RetrofitDataSource(private val marvelServiceManager: APIServiceManager): RemoteDataSource {

    override suspend fun getCharacterList(offset: Int): List<CharactersDomain> {
        val itemsResponse = marvelServiceManager.service.getAllCharacters(offset = offset)
        return itemsResponse.body()?.data!!.results.toList()
    }

    override suspend fun getCharacterInfo(characterID: Int): CharactersDomain {
        val itemsResponse = marvelServiceManager.service.getCharactersInfo(characterId = characterID)
        return itemsResponse.body()?.data!!.results.first()
    }
}
