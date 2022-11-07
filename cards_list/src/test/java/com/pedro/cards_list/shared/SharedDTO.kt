package com.pedro.cards_list.shared

import com.pedro.cards_list.data.dto.CardsDTO
import com.pedro.cards_list.data.dto.Classic
import com.pedro.cards_list.domain.model.CardsListModel

val successfulCardListModel = CardsListModel(
    cardId = "",
    img = "",
    name = ""
)

val successfulDTO by lazy {
    CardsDTO(
        classic = listOf(successfulClassic)
    )
}

private val successfulClassic = Classic(
    armor = "",
    artist = "",
    attack = 0,
    cardId = "",
    cardSet = "",
    collectible = false,
    cost = 0,
    dbfId = 0,
    durability = 0,
    elite = false,
    faction = "",
    flavor = "",
    health = 0,
    img = "",
    imgGold = "",
    locale = "",
    mechanics = null,
    name = "",
    playerClass = "",
    race = "",
    rarity = "",
    spellSchool = "",
    text = "",
    type = ""
)