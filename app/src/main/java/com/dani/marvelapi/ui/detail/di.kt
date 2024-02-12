package com.dani.marvelapi.ui.detail

import com.dani.usecase.GetCharacterInfoServerUseCase
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

@Module
@InstallIn(SingletonComponent::class)
class CharactersDetailModule() {

    var itemId: Int = 0

    @Provides
    fun charactersDetailViewModelProvider(getCharacterDetailUseCase: GetCharacterInfoServerUseCase)
            = DetailViewModel(itemId, getCharacterDetailUseCase)
}

@Subcomponent(modules = [(CharactersDetailModule::class)])
interface CharactersDetailComponent {
    val viewModel: DetailViewModel
}
