package com.pedro.cards_details.domain.usecase

import com.pedro.cards_details.domain.model.CardDetailModel
import com.pedro.cards_details.domain.repository.CardDetailRepository

interface GetCardByIdUseCase {
    suspend operator fun invoke(id: String): Result<CardDetailModel>
}

class GetCardByIdUseCaseImpl(
    private val repository: CardDetailRepository
) : GetCardByIdUseCase {
    override suspend fun invoke(id: String): Result<CardDetailModel> {
        return repository.getCardById(id = id)
    }
}
