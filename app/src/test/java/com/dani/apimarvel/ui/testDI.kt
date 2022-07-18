package com.dani.apimarvel.ui

import com.dani.data.source.LocalDataSource
import com.dani.data.source.RemoteDataSource
import com.dani.domain.Image
import com.dani.domain.Mycharacter

val mockedMycharacter = Mycharacter(
    0,
    "SuperHeroe",
    "Overview",
    "",
    mutableListOf(),
    Image("", "")
)


val defaultFakeMycharacter = listOf(
    mockedMycharacter.copy(1),
    mockedMycharacter.copy(2),
    mockedMycharacter.copy(3),
    mockedMycharacter.copy(4)
)

class FakeLocalDataSource : LocalDataSource {

    var characterList: List<Mycharacter> = emptyList()

    override suspend fun saveCharacters(list: List<Mycharacter>) {
        this.characterList = list
    }

    override suspend fun getCharacters(): List<Mycharacter> = characterList

    override suspend fun updateCharacter(characterID: Mycharacter) {
        characterList = characterList.filterNot { it.id == characterID.id } + characterID
    }

    override suspend fun findCharacterById(characterID: Int): Mycharacter =
        characterList.first { it.id == characterID }

}

class FakeRemoteDataSource : RemoteDataSource {

    private var characterList = defaultFakeMycharacter

    override suspend fun getCharacterList(offset: Int): List<Mycharacter> = characterList

    override suspend fun getCharacterInfo(characterID: Int): Mycharacter =
        characterList.first { it.id == characterID }
}
