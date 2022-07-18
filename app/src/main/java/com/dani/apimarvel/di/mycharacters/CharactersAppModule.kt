package com.dani.apimarvel.di.mycharacters

import com.dani.apimarvel.model.APIServiceManager
import com.dani.apimarvel.model.database.ApiCharactersDatabase
import com.dani.apimarvel.model.mycharacters.RetrofitDataSource
import com.dani.apimarvel.model.mycharacters.RoomDataSource
import com.dani.data.source.LocalDataSource
import com.dani.data.source.RemoteDataSource
import dagger.Module
import dagger.Provides

@Module
class CharactersAppModule {

    @Provides
    fun localDataSourceProvider(db: ApiCharactersDatabase): LocalDataSource = RoomDataSource(db)

    @Provides
    fun remoteDataSourceProvider(marvelServiceManager: APIServiceManager): RemoteDataSource
            = RetrofitDataSource(marvelServiceManager)
}
