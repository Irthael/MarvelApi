package com.dani.usecase

import com.dani.data.repository.CharacterRepository
import com.dani.domain.Mycharacter
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetCharacterInfoLocalUseCaseTest {

    @Mock
    lateinit var characterRepository: CharacterRepository

    lateinit var mockedCharacter : Mycharacter
    lateinit var getCharacter: GetCharacterInfoLocalUseCase

    @Before
    fun setUp() {
        mockedCharacter = mock()
        getCharacter = GetCharacterInfoLocalUseCase(characterRepository)
    }


    @Test
    fun `invoke GetCharacterInfoUseCase`() {
        runBlocking {
            val localMycharacter = mockedCharacter.copy(1)

            whenever(characterRepository.findCharacterById(ArgumentMatchers.anyInt())).thenReturn(localMycharacter)

            val result = getCharacter.invoke(1)

            assertEquals(localMycharacter, result)
        }
    }
}