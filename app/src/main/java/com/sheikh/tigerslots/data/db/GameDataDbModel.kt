package com.sheikh.tigerslots.data.db

data class GameDataDbModel(
    val deposit: Int,
    val bet: Int,
    val win: Boolean,
    val profit: Int
)