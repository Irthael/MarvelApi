package com.dani.marvelapi.di.mycharacters

import com.dani.data.repository.CharacterRepository
import com.dani.data.source.LocalDataSource
import com.dani.data.source.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class CharactersDataModule {

    @Provides
    fun itemsRepositoryProvider(
        localDataSource: LocalDataSource,
        remoteDataSource: RemoteDataSource
    ) = CharacterRepository(localDataSource, remoteDataSource)
}
