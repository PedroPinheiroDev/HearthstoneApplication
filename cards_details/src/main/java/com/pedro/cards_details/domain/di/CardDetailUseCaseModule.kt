package com.pedro.cards_details.domain.di

import com.pedro.cards_details.domain.usecase.GetCardByIdUseCase
import com.pedro.cards_details.domain.usecase.GetCardByIdUseCaseImpl
import org.koin.dsl.module

val cardDetailUseCaseModule = module {
    factory<GetCardByIdUseCase> {
        GetCardByIdUseCaseImpl(
            get()
        )
    }
}
