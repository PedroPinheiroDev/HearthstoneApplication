package com.pedro.cards_details.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pedro.cards_details.domain.usecase.GetCardByIdUseCase
import com.pedro.cards_details.presentation.state.CardsDetailScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CardsDetailsViewModel(
    private val useCase: GetCardByIdUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(CardsDetailScreenState().idle())
    val state: StateFlow<CardsDetailScreenState> get() = _state.asStateFlow()

    fun getCardById(itemId: String) {
        _state.update { it.onLoading() }.also {
            viewModelScope.launch {
                useCase(id = itemId).onSuccess { card ->
                    _state.update {
                        it.onSuccess(card = card)
                    }
                }
            }
        }
    }
}
