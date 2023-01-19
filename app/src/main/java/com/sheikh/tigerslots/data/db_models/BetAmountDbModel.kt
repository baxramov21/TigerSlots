package com.sheikh.tigerslots.data.db_models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bet_table")
data class BetAmountDbModel (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val bet: Int
): DbModelInstance(bet)