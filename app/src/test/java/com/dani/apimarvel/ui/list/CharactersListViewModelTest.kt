package com.dani.apimarvel.ui.list

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.dani.apimarvel.CoroutinesTestRule
import com.dani.apimarvel.ui.mockedMycharacter
import com.dani.usecase.GetCharacterListUseCase
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner


@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class CharactersListViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @get:Rule
    val coroutinesTestRule = CoroutinesTestRule()

    @Mock
    lateinit var getMycharacterListUseCase: GetCharacterListUseCase

    private lateinit var vm: MainViewModel



    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setUp(){
        Dispatchers.setMain(testDispatcher)
        vm = MainViewModel(getMycharacterListUseCase)
    }

    @After
    fun tearDown(){
        Dispatchers.resetMain()
    }

    @Test
    fun `state change when getting characters is called`() = runTest{
        val job = launch {
            vm.getCharacters(0)
        }
        runCurrent()
        assertTrue(vm.model.value == MainViewModel.UiModel.Loading)
        job.cancel()
    }

    @Test
    fun `UiModel Content is the correct state when get characters is called and value is returned`() = runTest{
        val mycharacters = listOf(mockedMycharacter.copy(id = 1), mockedMycharacter.copy(id = 2), mockedMycharacter.copy(id = 3))
        whenever(getMycharacterListUseCase.invoke(0)).thenReturn(mycharacters)

        val job = launch {
            vm.getCharacters(0)
        }

        runCurrent()
        assertTrue(vm.model.value != MainViewModel.UiModel.Loading)

        job.cancel()
    }
}