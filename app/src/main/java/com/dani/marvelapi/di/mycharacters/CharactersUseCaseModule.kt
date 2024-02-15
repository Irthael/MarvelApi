package com.dani.marvelapi.di.mycharacters

import com.dani.data.repository.CharacterRepository
import com.dani.usecase.GetCharacterInfoServerUseCase
import com.dani.usecase.GetCharacterInfoLocalUseCase
import com.dani.usecase.GetCharacterListFilterUseCase
import com.dani.usecase.GetCharacterListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class CharactersUseCaseModule {

    @Provides
    fun getCharactersLocalProvider(charactersRepository: CharacterRepository) = GetCharacterInfoLocalUseCase(charactersRepository)

    @Provides
    fun getCharactersServerProvider(charactersRepository: CharacterRepository) = GetCharacterInfoServerUseCase(charactersRepository)

    @Provides
    fun getCharactersListProvider(charactersRepository: CharacterRepository) = GetCharacterListUseCase(charactersRepository)

    @Provides
    fun getCharactersListFilterProvider(charactersRepository: CharacterRepository) = GetCharacterListFilterUseCase(charactersRepository)
}
