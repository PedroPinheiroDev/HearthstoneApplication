package com.pedro.cards_list.data.di

import com.pedro.cards_list.data.repository.ClassicCardsRepositoryImpl
import com.pedro.cards_list.domain.repository.ClassicCardsRepository
import org.koin.dsl.module

val cardListRepositoryModule = module {
    factory<ClassicCardsRepository> {
        ClassicCardsRepositoryImpl(
            get()
        )
    }
}