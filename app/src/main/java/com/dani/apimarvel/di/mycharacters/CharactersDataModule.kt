package com.dani.apimarvel.di.mycharacters

import com.dani.data.repository.CharacterRepository
import com.dani.data.source.LocalDataSource
import com.dani.data.source.RemoteDataSource
import dagger.Module
import dagger.Provides

@Module
class CharactersDataModule {

    @Provides
    fun itemsRepositoryProvider(
        localDataSource: LocalDataSource,
        remoteDataSource: RemoteDataSource
    ) = CharacterRepository(localDataSource, remoteDataSource)
}
