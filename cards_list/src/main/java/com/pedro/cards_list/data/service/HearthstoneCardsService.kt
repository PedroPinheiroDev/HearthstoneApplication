package com.pedro.cards_list.data.service

import com.pedro.cards_list.data.dto.CardsDTO
import retrofit2.Response
import retrofit2.http.GET

interface HearthstoneCardsService {

    @GET("cards")
    suspend fun getAllCards(): Response<CardsDTO>
}
