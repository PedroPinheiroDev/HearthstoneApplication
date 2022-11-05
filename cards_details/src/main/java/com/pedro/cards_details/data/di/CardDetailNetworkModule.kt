package com.pedro.cards_details.data.di

import com.pedro.cards_details.data.service.CardDetailService
import org.koin.dsl.module
import retrofit2.Retrofit

val cardDetailNetworkModule = module {
    single {
        get<Retrofit>().create(CardDetailService::class.java)
    }
}