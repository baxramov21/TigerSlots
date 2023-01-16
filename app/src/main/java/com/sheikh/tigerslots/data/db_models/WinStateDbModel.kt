package com.sheikh.tigerslots.data.db_models

import androidx.room.Entity

@Entity(tableName = "wins_table")
data class WinStateDbModel(
    val win: Boolean
)