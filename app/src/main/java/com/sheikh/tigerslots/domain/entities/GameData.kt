package com.sheikh.tigerslots.domain.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class GameData(
    val deposit: Int,
    val bet: Int,
    val win: Boolean,
    val profit: Int
)