package com.pedro.cards_list.domain.usecase

import com.pedro.cards_list.domain.model.CardsListModel
import com.pedro.cards_list.domain.repository.ClassicCardsRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.RelaxedMockK
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class GetClassicCardsUseCaseTest {

    @RelaxedMockK
    lateinit var useCase: GetClassicCardsUseCase

    @MockK
    lateinit var repository: ClassicCardsRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        useCase = GetClassicCardsUseCaseImpl(repository = repository)
    }

    @Test
    fun `Given successful request WHEN called getAllCards THEN return the list of objects`() =
        runTest {
            coEvery { repository.getAllCards() } returns Result.success(listOf())
            val expected = Result.success(listOf<CardsListModel>())
            val result = useCase()
            assertEquals(expected, result)
        }
}