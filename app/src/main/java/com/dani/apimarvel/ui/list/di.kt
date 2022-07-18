package com.dani.apimarvel.ui.list

import com.dani.usecase.GetCharacterListUseCase
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

@Module
class CharactersListActivityModule {

    @Provides
    fun charactersListViewModelProvider(getCharacterListUseCase: GetCharacterListUseCase)
            = MainViewModel(getCharacterListUseCase)
}

@Subcomponent(modules = [(CharactersListActivityModule::class)])
interface CharactersListActivityComponent {
    val viewModel: MainViewModel
}
