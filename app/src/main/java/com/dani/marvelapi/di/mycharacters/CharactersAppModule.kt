package com.dani.marvelapi.di.mycharacters

import com.dani.marvelapi.model.APIServiceManager
import com.dani.marvelapi.model.database.ApiCharactersDatabase
import com.dani.marvelapi.model.mycharacters.RetrofitDataSource
import com.dani.marvelapi.model.mycharacters.RoomDataSource
import com.dani.data.source.LocalDataSource
import com.dani.data.source.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class CharactersAppModule {

    @Provides
    fun localDataSourceProvider(db: ApiCharactersDatabase): LocalDataSource = RoomDataSource(db)

    @Provides
    fun remoteDataSourceProvider(marvelServiceManager: APIServiceManager): RemoteDataSource
            = RetrofitDataSource(marvelServiceManager)
}
