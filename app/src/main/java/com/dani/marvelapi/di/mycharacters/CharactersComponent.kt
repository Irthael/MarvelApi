package com.dani.marvelapi.di.mycharacters

import android.app.Application
import com.dani.marvelapi.di.DataSourcesModule
import com.dani.marvelapi.ui.detail.CharactersDetailComponent
import com.dani.marvelapi.ui.detail.CharactersDetailModule
import com.dani.marvelapi.ui.list.CharactersListActivityComponent
import com.dani.marvelapi.ui.list.CharactersListActivityModule
import dagger.BindsInstance
import dagger.Component
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Singleton
@Component(modules = [
    CharactersAppModule::class,
    CharactersDataModule::class,
    CharactersUseCaseModule::class,
    DataSourcesModule::class
])

interface CharactersComponent {

    fun plus(charactersListActivityModule: CharactersListActivityModule): CharactersListActivityComponent
    fun plus(charactersDetail2ActivityModule: CharactersDetailModule): CharactersDetailComponent

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application): CharactersComponent
    }
}
