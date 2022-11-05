package com.pedro.cards_details.data.di

import com.pedro.cards_details.data.repository.CardDetailRepositoryImpl
import com.pedro.cards_details.domain.repository.CardDetailRepository
import org.koin.dsl.module

val cardDetailRepositoryModule = module {
    factory<CardDetailRepository> {
        CardDetailRepositoryImpl(
            get()
        )
    }
}