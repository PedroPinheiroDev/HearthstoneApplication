package com.pedro.cards_details.domain.repository

import com.pedro.cards_details.domain.model.CardDetailModel

interface CardDetailRepository {
    suspend fun getCardById(id: String): Result<CardDetailModel>
}
