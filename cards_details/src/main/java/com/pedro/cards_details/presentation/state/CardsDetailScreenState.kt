package com.pedro.cards_details.presentation.state

import com.pedro.cards_details.domain.model.CardDetailModel
import com.pedro.cards_details.domain.model.CardDetailModel.Companion.defaultCardDetail

data class CardsDetailScreenState(
    val card: CardDetailModel = defaultCardDetail,
    val loading: Boolean = false
) {
    fun idle() = copy(card = defaultCardDetail)

    fun onLoading() = copy(loading = true)

    fun onSuccess(card: CardDetailModel) = copy(
        card = card,
        loading = false
    )
}
