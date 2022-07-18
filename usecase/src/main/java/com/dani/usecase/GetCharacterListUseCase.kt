package com.dani.usecase

import com.dani.data.repository.CharacterRepository
import com.dani.domain.Mycharacter

class GetCharacterListUseCase(private val charactersRepository: CharacterRepository) {
    suspend fun invoke(offset: Int): List<Mycharacter> = charactersRepository.getCharactersList(offset)
}
