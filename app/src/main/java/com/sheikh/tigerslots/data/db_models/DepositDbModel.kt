package com.sheikh.tigerslots.data.db_models

import androidx.room.Entity

@Entity(tableName = "deposit_table")
data class DepositDbModel (
    val deposit: Int
): DbModelInstance(deposit)