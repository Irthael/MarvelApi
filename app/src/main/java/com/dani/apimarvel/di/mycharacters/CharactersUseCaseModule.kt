package com.dani.apimarvel.di.mycharacters

import com.dani.data.repository.CharacterRepository
import com.dani.usecase.GetCharacterInfoServerUseCase
import com.dani.usecase.GetCharacterInfoLocalUseCase
import com.dani.usecase.GetCharacterListUseCase
import dagger.Module
import dagger.Provides

@Module
class CharactersUseCaseModule {

    @Provides
    fun getCharactersProvider(charactersRepository: CharacterRepository) = GetCharacterInfoLocalUseCase(charactersRepository)

    @Provides
    fun getCharacters2Provider(charactersRepository: CharacterRepository) = GetCharacterInfoServerUseCase(charactersRepository)

    @Provides
    fun getGetCharactersProvider(charactersRepository: CharacterRepository) = GetCharacterListUseCase(charactersRepository)
}
