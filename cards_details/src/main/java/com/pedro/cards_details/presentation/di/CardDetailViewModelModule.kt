package com.pedro.cards_details.presentation.di

import com.pedro.cards_details.presentation.viewmodel.CardsDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val cardsDetailViewModelModule = module {
    viewModel {
        CardsDetailsViewModel(
            useCase = get()
        )
    }
}
