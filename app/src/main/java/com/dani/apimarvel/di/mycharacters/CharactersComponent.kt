package com.dani.apimarvel.di.mycharacters

import android.app.Application
import com.dani.apimarvel.di.DataSourcesModule
import com.dani.apimarvel.ui.detail.CharactersDetailComponent
import com.dani.apimarvel.ui.detail.CharactersDetailModule
import com.dani.apimarvel.ui.list.CharactersListActivityComponent
import com.dani.apimarvel.ui.list.CharactersListActivityModule
import dagger.BindsInstance
import dagger.Component
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
