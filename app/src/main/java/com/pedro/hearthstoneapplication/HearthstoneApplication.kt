package com.pedro.hearthstoneapplication

import android.app.Application
import com.pedro.cards_details.data.di.cardDetailNetworkModule
import com.pedro.cards_details.data.di.cardDetailRepositoryModule
import com.pedro.cards_details.domain.di.cardDetailUseCaseModule
import com.pedro.cards_details.presentation.di.cardsDetailViewModelModule
import com.pedro.cards_list.data.di.cardsDataModule
import com.pedro.cards_list.data.di.cardListRepositoryModule
import com.pedro.cards_list.domain.di.cardsDomainModule
import com.pedro.cards_list.presentation.di.cardsViewModelModule
import com.pedro.core.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class HearthstoneApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@HearthstoneApplication)
            modules(
                networkModule,
                cardsDataModule,
                cardListRepositoryModule,
                cardsDomainModule,
                cardsViewModelModule,
                cardsDetailViewModelModule,
                cardDetailNetworkModule,
                cardDetailRepositoryModule,
                cardDetailUseCaseModule
            )
        }
    }
}
