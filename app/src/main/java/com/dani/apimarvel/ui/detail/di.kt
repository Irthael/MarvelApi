package com.dani.apimarvel.ui.detail

import com.dani.usecase.GetCharacterInfoServerUseCase
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

@Module
class CharactersDetailModule(private val itemId: Int) {

    @Provides
    fun charactersDetailViewModelProvider(getCharacterDetailUseCase: GetCharacterInfoServerUseCase)
            = DetailViewModel(itemId, getCharacterDetailUseCase)
}

@Subcomponent(modules = [(CharactersDetailModule::class)])
interface CharactersDetailComponent {
    val viewModel: DetailViewModel
}
