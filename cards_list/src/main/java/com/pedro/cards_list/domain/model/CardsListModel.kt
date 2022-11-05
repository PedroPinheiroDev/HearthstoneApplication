package com.pedro.cards_list.domain.model

data class CardsListModel(
    val cardId: String,
    val img: String,
    val name: String
) {
    companion object {
        val defaultCardList = listOf<CardsListModel>()
    }
}
