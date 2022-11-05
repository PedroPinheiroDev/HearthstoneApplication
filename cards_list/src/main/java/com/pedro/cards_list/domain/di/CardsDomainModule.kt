package com.pedro.cards_list.domain.di

import com.pedro.cards_list.domain.usecase.GetAllCardsUseCase
import com.pedro.cards_list.domain.usecase.GetAllCardsUseCaseImpl
import org.koin.dsl.module

val cardsDomainModule = module {
    factory<GetAllCardsUseCase> {
        GetAllCardsUseCaseImpl(
            get()
        )
    }
}
