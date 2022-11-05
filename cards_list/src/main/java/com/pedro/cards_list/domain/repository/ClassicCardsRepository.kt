package com.pedro.cards_list.domain.repository

import com.pedro.cards_list.domain.model.CardsListModel

interface ClassicCardsRepository {
    suspend fun getAllCards(): Result<List<CardsListModel>>
}
