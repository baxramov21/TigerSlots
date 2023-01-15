package com.sheikh.tigerslots.data.db

import androidx.room.Entity

@Entity(tableName = "deposit_table")
data class DepositDbModel (
    val deposit: Int
)