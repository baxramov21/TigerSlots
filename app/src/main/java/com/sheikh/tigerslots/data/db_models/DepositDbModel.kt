package com.sheikh.tigerslots.data.db_models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "deposit_table")
data class DepositDbModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val deposit: Int
)
//    : DbModelInstance(deposit)