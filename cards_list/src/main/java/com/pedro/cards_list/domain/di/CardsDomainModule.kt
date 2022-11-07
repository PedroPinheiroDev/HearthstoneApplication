package com.pedro.cards_list.domain.di

import com.pedro.cards_list.domain.usecase.GetClassicCardsUseCase
import com.pedro.cards_list.domain.usecase.GetClassicCardsUseCaseImpl
import org.koin.dsl.module

val cardsDomainModule = module {
    factory<GetClassicCardsUseCase> {
        GetClassicCardsUseCaseImpl(
            get()
        )
    }
}
