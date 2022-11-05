package com.pedro.cards_list.data.dto

data class Classic(
    val armor: String?,
    val artist: String?,
    val attack: Int?,
    val cardId: String?,
    val cardSet: String?,
    val collectible: Boolean?,
    val cost: Int?,
    val dbfId: Int?,
    val durability: Int?,
    val elite: Boolean?,
    val faction: String?,
    val flavor: String?,
    val health: Int?,
    val img: String?,
    val imgGold: String?,
    val locale: String?,
    val mechanics: List<Mechanic>?,
    val name: String?,
    val playerClass: String?,
    val race: String?,
    val rarity: String?,
    val spellSchool: String?,
    val text: String?,
    val type: String?
)
