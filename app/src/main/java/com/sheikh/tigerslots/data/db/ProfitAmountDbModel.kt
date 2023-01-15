package com.sheikh.tigerslots.data.db

import androidx.room.Entity

@Entity(tableName = "profit_table")
data class ProfitAmountDbModel (
    val profit: Int
)