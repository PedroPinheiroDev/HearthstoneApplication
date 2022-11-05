package com.pedro.cards_list.presentation.state

import com.pedro.cards_list.domain.model.CardsListModel

data class CardsListScreenState(
    val error: Boolean = false,
    val cardsList: List<CardsListModel> = emptyList(),
    val loading: Boolean = false
) {
    fun idle() = copy(
        error = false,
        cardsList = emptyList(),
        loading = true
    )

    fun onSuccessfulRequest(cardsList: List<CardsListModel>) = copy(
        error = false,
        loading = false,
        cardsList = cardsList
    )

    fun onUnsuccessfulRequest() = copy(
        error = true,
        loading = false,
        cardsList = emptyList()
    )

    fun onLazyLoading() = copy(
        error = false, loading = true
    )
}
