package com.dani.apimarvel.ui.detail

import androidx.lifecycle.*
import com.dani.domain.Mycharacter
import com.dani.usecase.GetCharacterInfoServerUseCase
import kotlinx.coroutines.launch

class DetailViewModel(private val itemId: Int,
                      private val getItem: GetCharacterInfoServerUseCase):
    ViewModel() {

    private val _character = MutableLiveData<Mycharacter>()

    val characterDetailt: LiveData<Mycharacter>
        get() {
            if (_character.value == null) getCharacterInfo(itemId)
            return _character
        }

    private fun getCharacterInfo(itemId: Int) = viewModelScope.launch {
        _character.value = getItem.invoke(itemId)
    }
}
