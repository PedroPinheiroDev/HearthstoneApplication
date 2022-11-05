package com.pedro.cards_list.data.di

import com.pedro.cards_list.data.service.HearthstoneCardsService
import org.koin.dsl.module
import retrofit2.Retrofit

val cardsDataModule = module {
    single {
        get<Retrofit>().create(HearthstoneCardsService::class.java)
    }
}
