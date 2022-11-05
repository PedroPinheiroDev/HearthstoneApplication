package com.pedro.cards_list.data.dto

import com.google.gson.annotations.SerializedName

data class CardsDTO(
    @SerializedName("Classic")
    val classic: List<Classic>
)
