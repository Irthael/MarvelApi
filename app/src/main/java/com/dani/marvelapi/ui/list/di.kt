package com.dani.marvelapi.ui.list

import com.dani.usecase.GetCharacterListUseCase
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class CharactersListActivityModule {

    @Provides
    fun charactersListViewModelProvider(getCharacterListUseCase: GetCharacterListUseCase)
            = MainViewModel(getCharacterListUseCase)
}

@Subcomponent(modules = [(CharactersListActivityModule::class)])
interface CharactersListActivityComponent {
    val viewModel: MainViewModel
}
