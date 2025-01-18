package com.example.dogslista.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogslista.data.DogRepository
import com.example.dogslista.data.entities.DogEntity
import com.example.dogslista.viewmodel.UiState.Loading
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class DogsViewModel @Inject constructor(
    private val dogRepository: DogRepository
) : ViewModel() {

    val uiState: StateFlow<Any> = dogRepository
        .dogs
        .catch { emit(UiState.Error(it)) }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), Loading)

    private fun emit(value: UiState.Error) {

    }

    fun addDog(name: String) {
        viewModelScope.launch {
            dogRepository.add(name)
        }
    }

    fun removeDog(id: Int) {
        viewModelScope.launch {
            dogRepository.remove(id)
        }
    }

    fun triggerFav(id: Int) {
        viewModelScope.launch {
            dogRepository.triggerFav(id)
        }
    }
}

sealed interface UiState {
    object Loading : UiState
    data class Error(val throwable: Throwable) : UiState
    data class Success(val data: List<DogEntity>) : UiState
}
