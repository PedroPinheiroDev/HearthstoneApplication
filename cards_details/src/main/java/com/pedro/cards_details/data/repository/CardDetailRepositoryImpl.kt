package com.pedro.cards_details.data.repository

import com.pedro.cards_details.data.service.CardDetailService
import com.pedro.cards_details.data.mapper.toDomainModel
import com.pedro.cards_details.domain.model.CardDetailModel
import com.pedro.cards_details.domain.model.CardDetailModel.Companion.defaultCardDetail
import com.pedro.cards_details.domain.repository.CardDetailRepository

class CardDetailRepositoryImpl(
    private val service: CardDetailService
) : CardDetailRepository {
    override suspend fun getCardById(id: String): Result<CardDetailModel> {
        return runCatching {
            val response = service.getCardById(id = id).body()
            response?.toDomainModel() ?: defaultCardDetail
        }
    }
}
