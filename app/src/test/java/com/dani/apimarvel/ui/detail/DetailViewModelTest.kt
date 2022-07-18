package com.dani.apimarvel.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.dani.apimarvel.CoroutinesTestRule
import com.dani.apimarvel.ui.mockedMycharacter
import com.dani.usecase.GetCharacterInfoServerUseCase
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner


@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @get:Rule
    val coroutinesTestRule = CoroutinesTestRule()

    @Mock
    lateinit var getMycharacterInfoUseCase: GetCharacterInfoServerUseCase

    private lateinit var vm: DetailViewModel



    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setUp(){
        Dispatchers.setMain(testDispatcher)
        vm = DetailViewModel(0, getMycharacterInfoUseCase)
    }

    @After
    fun tearDown(){
        Dispatchers.resetMain()
    }

    @Test
    fun `character downloaded when load value`() = runTest{
        val mycharacter = mockedMycharacter.copy(id = 0)
        whenever(getMycharacterInfoUseCase.invoke(0)).thenReturn(mycharacter)

        val job = launch {
            vm.characterDetailt
        }
        runCurrent()
        assertTrue(vm.characterDetailt.value == mycharacter)
        job.cancel()
    }
}