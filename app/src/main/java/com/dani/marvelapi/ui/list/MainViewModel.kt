package com.dani.marvelapi.ui.list

import androidx.lifecycle.*
import com.dani.domain.Mycharacter
import com.dani.usecase.GetCharacterListUseCase
import kotlinx.coroutines.launch

class MainViewModel(private val getCharacterListUseCase : GetCharacterListUseCase)
    : ViewModel() {

    sealed class UiModel {
        object Loading : UiModel()
        class Content(val items: List<Mycharacter>): UiModel()
        class Navigation(val item: Mycharacter): UiModel()
    }

    private val _model = MutableLiveData<UiModel>()
    val model: LiveData<UiModel> = _model

    fun getCharacters(offset: Int, name: String){
        viewModelScope.launch {
            _model.value = UiModel.Loading
            if (name.isBlank() || name.isEmpty()){
                _model.value = UiModel.Content( getCharacterListUseCase.getNormalList(offset) )
            } else {
                _model.value = UiModel.Content( getCharacterListUseCase.getListFilter(0, name) )
            }
        }
    }

    fun onItemClicked(item: Mycharacter){
        _model.value =
            UiModel.Navigation(
                item
            )
    }
}
