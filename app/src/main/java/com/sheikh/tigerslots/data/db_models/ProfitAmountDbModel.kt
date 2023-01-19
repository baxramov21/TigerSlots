package com.sheikh.tigerslots.data.db_models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "profit_table")
data class ProfitAmountDbModel (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val profit: Int
): DbModelInstance(profit)