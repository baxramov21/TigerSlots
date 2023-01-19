package com.sheikh.tigerslots.data.db_models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wins_table")
data class WinStateDbModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val win: Boolean
)