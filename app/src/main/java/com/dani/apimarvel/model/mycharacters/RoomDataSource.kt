package com.dani.apimarvel.model.mycharacters

import com.dani.apimarvel.model.database.ApiCharactersDatabase
import com.dani.apimarvel.model.database.entities.CharactersEntity
import com.dani.data.source.LocalDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.dani.domain.Mycharacter as CharactersDomain

class RoomDataSource(database: ApiCharactersDatabase) : LocalDataSource {

    private val dao = database.apiCharactersDao()

    override suspend fun saveCharacters(list: List<CharactersDomain>) = withContext(Dispatchers.IO) {
        dao.insertCharacter(list.map(CharactersDomain::toCharactersEntity))
    }

    override suspend fun getCharacters(): List<CharactersDomain> = withContext(Dispatchers.IO){
        dao.getAllCharacters().map(CharactersEntity::toCharactersDomain)
    }

    override suspend fun updateCharacter(characterID: CharactersDomain) = withContext(Dispatchers.IO){
        dao.updateCharacters(characterID.toCharactersEntity())
    }

    override suspend fun findCharacterById(characterID: Int) = withContext(Dispatchers.IO) {
        dao.getCharactersById(characterID).toCharactersDomain()}
}
