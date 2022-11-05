package com.pedro.cards_details.domain.model

data class CardDetailModel(
    val attack: Int,
    val cardId: String,
    val cost: Int,
    val faction: String,
    val health: Int,
    val img: String,
    val locale: String,
    val name: String,
    val race: String,
    val rarity: String,
    val type: String
) {
    companion object {
        val defaultCardDetail = CardDetailModel(
            attack = 0,
            cardId = "",
            cost = 0,
            faction = "",
            health = 0,
            img = "",
            locale = "",
            name = "",
            race = "",
            rarity = "",
            type = ""
        )
    }
}
