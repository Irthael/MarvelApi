package com.dani.usecase

import com.dani.data.repository.CharacterRepository
import com.dani.domain.Mycharacter

class GetCharacterInfoLocalUseCase(private val characterRepository: CharacterRepository) {
    suspend fun invoke(characterID: Int): Mycharacter = characterRepository.findCharacterById(characterID)
}
