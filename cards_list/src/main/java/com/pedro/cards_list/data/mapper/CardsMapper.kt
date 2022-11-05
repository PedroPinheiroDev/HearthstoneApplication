package com.pedro.cards_list.data.mapper

import com.pedro.cards_list.data.dto.CardsDTO
import com.pedro.cards_list.domain.model.CardsListModel

fun CardsDTO.toDomainModel(): List<CardsListModel> {
    return let { cards ->
        cards.classic
            .filter { it.img != null }
            .map { classic ->
                CardsListModel(
                    cardId = classic.cardId ?: "Unknown",
                    img = classic.img ?: "",
                    name = classic.name ?: "Unknown"
                )
            }
    }
}
