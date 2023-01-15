package com.sheikh.tigerslots.data.db

import androidx.room.Entity

@Entity(tableName = "wins_table")
data class WinStateDbModel(
    val win: Boolean
)