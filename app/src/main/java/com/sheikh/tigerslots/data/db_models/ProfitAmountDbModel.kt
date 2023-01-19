package com.sheikh.tigerslots.data.db_models

import androidx.room.Entity

@Entity(tableName = "profit_table")
data class ProfitAmountDbModel (
    val profit: Int
): DbModelInstance(profit)