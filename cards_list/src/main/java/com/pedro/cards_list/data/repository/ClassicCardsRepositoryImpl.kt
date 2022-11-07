package com.pedro.cards_list.data.repository

import com.pedro.cards_list.data.service.HearthstoneCardsService
import com.pedro.cards_list.data.mapper.toDomainModel
import com.pedro.cards_list.domain.model.CardsListModel
import com.pedro.cards_list.domain.model.CardsListModel.Companion.defaultCardList
import com.pedro.cards_list.domain.repository.ClassicCardsRepository

class ClassicCardsRepositoryImpl(
    private val service: HearthstoneCardsService
) : ClassicCardsRepository {
    override suspend fun getAllCards(): Result<List<CardsListModel>> {
        return runCatching {
            val response = service.getAllCards()?.body()
            response?.toDomainModel() ?: defaultCardList
        }
    }
}