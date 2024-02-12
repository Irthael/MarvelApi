package com.dani.marvelapi.di

import android.app.Application
import androidx.room.Room
import com.dani.marvelapi.model.APIServiceManager
import com.dani.marvelapi.model.database.ApiCharactersDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
open class DataSourcesModule {

    @Provides @Singleton
    fun databaseProvider(app: Application): ApiCharactersDatabase = Room.databaseBuilder(
        app,
        ApiCharactersDatabase::class.java,
        "api_db"
    ).build()

    @Provides
    @Singleton
    @Named("baseUrl")
    fun baseUrlProvider(): String = "https://gateway.marvel.com:443/"

    @Provides
    @Singleton
    fun marvelServiceManagerProvider(@Named("baseUrl") baseUrl: String): APIServiceManager
            = APIServiceManager(baseUrl)
}
