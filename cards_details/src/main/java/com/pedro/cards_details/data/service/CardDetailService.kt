package com.pedro.cards_details.data.service

import com.pedro.cards_details.data.dto.CardDetailList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CardDetailService {

    @GET("/cards/{id}")
    suspend fun getCardById(@Path("id") id: String): Response<CardDetailList>
}
