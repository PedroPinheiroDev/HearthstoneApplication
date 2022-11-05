package com.pedro.cards_list.presentation.event

sealed interface CardsListScreenEvent {
    object OnRetry : CardsListScreenEvent
}
