package com.pedro.cards_list.presentation.di

import com.pedro.cards_list.presentation.viewmodel.CardsListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val cardsViewModelModule = module {
    viewModel {
        CardsListViewModel(
            get()
        )
    }
}
