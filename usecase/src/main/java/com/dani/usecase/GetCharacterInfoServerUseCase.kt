package com.dani.usecase

import com.dani.data.repository.CharacterRepository
import com.dani.domain.Mycharacter

class GetCharacterInfoServerUseCase(private val characterRepository: CharacterRepository) {
    suspend fun invoke(characterID: Int): Mycharacter = characterRepository.findCharacterByIdInServer(characterID)
}
