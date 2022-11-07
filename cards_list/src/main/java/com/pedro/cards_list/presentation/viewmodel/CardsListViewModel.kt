package com.pedro.cards_list.presentation.viewmodel

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pedro.cards_list.domain.usecase.GetClassicCardsUseCase
import com.pedro.cards_list.presentation.event.CardsListScreenEvent
import com.pedro.cards_list.presentation.state.CardsListScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CardsListViewModel(
    private val useCase: GetClassicCardsUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(CardsListScreenState().idle())
    val state: StateFlow<CardsListScreenState> get() = _state.asStateFlow()

    init {
        getClassicCards()
    }

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    fun getClassicCards() {
        viewModelScope.launch {
            useCase().onSuccess { list ->
                _state.update {
                    it.onSuccessfulRequest(cardsList = list)
                }
            }.onFailure {
                _state.update {
                    it.onUnsuccessfulRequest()
                }
            }
        }
    }

    private fun onLazyLoading() {
        _state.update {
            it.onLazyLoading()
        }.also { getClassicCards() }
    }

    fun onEvent(event: CardsListScreenEvent) {
        when (event) {
            is CardsListScreenEvent.OnRetry -> {
                onLazyLoading()
            }
        }
    }
}
