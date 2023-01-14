package com.sheikh.tigerslots.domain.entities

data class GameData(
    val deposit: Int,
    val bet: Int,
    val win: Boolean,
    val profit: Int
)