package com.pedro.cards_details.data.mapper

import com.pedro.cards_details.data.dto.CardDetailList
import com.pedro.cards_details.domain.model.CardDetailModel

fun CardDetailList.toDomainModel(): CardDetailModel {
    return with(this.first()) {
        CardDetailModel(
            attack = attack ?: 0,
            cardId = cardId ?: "Unknown",
            cost = cost ?: 0,
            faction = faction ?: "Unknown",
            health = health ?: 0,
            img = img ?: "Unknown",
            locale = locale ?: "Unknown",
            name = name ?: "Unknown",
            race = race ?: "Unknown",
            rarity = rarity ?: "Unknown",
            type = type ?: "Unknown"
        )
    }
}
