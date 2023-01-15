package com.sheikh.tigerslots.data.db

import androidx.room.Entity

@Entity(tableName = "bet_table")
data class BetAmountDbModel (
    val bet: Int
)