package com.pedro.cards_list.domain.usecase

import com.pedro.cards_list.domain.model.CardsListModel
import com.pedro.cards_list.domain.repository.ClassicCardsRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface GetAllCardsUseCase {
    suspend operator fun invoke(dispatcher: CoroutineDispatcher = Dispatchers.IO): Result<List<CardsListModel>>
}

class GetAllCardsUseCaseImpl(
    private val repository: ClassicCardsRepository
) : GetAllCardsUseCase {
    override suspend fun invoke(dispatcher: CoroutineDispatcher): Result<List<CardsListModel>> {
        return withContext(Dispatchers.IO) {
            repository.getAllCards()
        }
    }
}
