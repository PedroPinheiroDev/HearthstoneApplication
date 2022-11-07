package com.pedro.cards_list.data.repository

import com.pedro.cards_list.data.service.HearthstoneCardsService
import com.pedro.cards_list.domain.model.CardsListModel.Companion.defaultCardList
import com.pedro.cards_list.domain.repository.ClassicCardsRepository
import com.pedro.cards_list.shared.successfulCardListModel
import com.pedro.cards_list.shared.successfulDTO
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.RelaxedMockK
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import retrofit2.Response

@OptIn(ExperimentalCoroutinesApi::class)
class ClassicCardsRepositoryTest {

    @RelaxedMockK
    lateinit var repository: ClassicCardsRepository

    @MockK
    lateinit var service: HearthstoneCardsService

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        repository = ClassicCardsRepositoryImpl(service = service)
    }

    @Test
    fun `GIVEN null response WHEN called getAllCards THEN return the default object`() = runTest {
        coEvery { service.getAllCards() } returns null
        val expected = Result.success(defaultCardList)
        val result = repository.getAllCards()
        assertEquals(expected, result)
    }

    @Test
    fun `GIVEN successful request WHEN called getAllCards THEN return the objects`() = runTest {
        coEvery { service.getAllCards() } returns Response.success(successfulDTO)
        val expected = Result.success(listOf(successfulCardListModel))
        val result = repository.getAllCards()
        assertEquals(expected, result)
    }
}