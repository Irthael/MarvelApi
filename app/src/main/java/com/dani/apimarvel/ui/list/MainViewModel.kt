package com.dani.apimarvel.ui.list

import androidx.lifecycle.*
import com.dani.domain.Mycharacter
import com.dani.usecase.GetCharacterListUseCase
import kotlinx.coroutines.launch
import com.dani.apimarvel.ui.common.Event

class MainViewModel(private val getCharacterListUseCase : GetCharacterListUseCase)
    : ViewModel() {

    sealed class UiModel {
        object Loading : UiModel()
        class Content(val items: List<Mycharacter>): UiModel()
        class Navigation(val item: Mycharacter): UiModel()
    }

    private val _model = MutableLiveData<UiModel>()
    val model: LiveData<UiModel> = _model

    fun getCharacters(offset: Int){
        viewModelScope.launch {
            _model.value = UiModel.Loading
            _model.value = UiModel.Content( getCharacterListUseCase.invoke(offset) )
        }
    }

    fun onItemClicked(item: Mycharacter){
        _model.value =
            UiModel.Navigation(
                item
            )
    }
}
