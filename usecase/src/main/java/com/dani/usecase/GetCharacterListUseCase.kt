package com.dani.usecase

import com.dani.data.repository.CharacterRepository
import com.dani.domain.Mycharacter

class GetCharacterListUseCase(private val charactersRepository: CharacterRepository) {
    suspend fun getNormalList(offset: Int): List<Mycharacter> = charactersRepository.getCharactersList(offset)
    suspend fun getListFilter(offset: Int, name: String): List<Mycharacter> = charactersRepository.getCharactersListFilter(offset, name)
}
