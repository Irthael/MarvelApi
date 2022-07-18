package com.dani.data

import com.dani.data.repository.CharacterRepository
import com.dani.data.source.LocalDataSource
import com.dani.data.source.RemoteDataSource
import com.dani.domain.Image
import com.dani.domain.Mycharacter
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CharacterRepositoryTest {

    @Mock
    lateinit var localDataSource: LocalDataSource

    @Mock
    lateinit var remoteDataSource: RemoteDataSource

    lateinit var characterRepository: CharacterRepository

    var mockedCharacter = Mycharacter(
        0,
        "",
        "",
        "",
        mutableListOf(),
        Image("", "")
    )

    @Before
    fun setUp() {
        localDataSource = mock()
        remoteDataSource = mock()
        characterRepository = CharacterRepository(
            localDataSource,
            remoteDataSource
        )
    }

    @Test
    fun `get character from server first`() {
        runBlocking {
            val localMycharacterList = mutableListOf(mockedCharacter.copy(1))

            whenever(localDataSource.getCharacters()).thenReturn(localMycharacterList)

            val result = characterRepository.getCharactersList(0)

            assertEquals(localMycharacterList, result)
        }
    }

    @Test
    fun `get character info from database with id`() {
        runBlocking {
            val localMycharacter = mockedCharacter.copy(1)

            whenever(localDataSource.findCharacterById(0)).thenReturn(localMycharacter)

            val result = characterRepository.findCharacterById(0)

            assertEquals(localMycharacter, result)
        }
    }

    @Test
    fun `get character info from server with id`() {
        runBlocking {
            val localMycharacter = mockedCharacter.copy(1)

            whenever(remoteDataSource.getCharacterInfo(0)).thenReturn(localMycharacter)

            val result = characterRepository.findCharacterByIdInServer(0)

            assertEquals(localMycharacter, result)
        }
    }
}