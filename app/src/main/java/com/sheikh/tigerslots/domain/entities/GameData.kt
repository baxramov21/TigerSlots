package com.sheikh.tigerslots.domain.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "game_data_table")
data class GameData(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "deposit")
    val deposit: Int,
    @ColumnInfo(name = "bet")
    val bet: Int,
    @ColumnInfo(name = "win")
    val win: Boolean,
    @ColumnInfo(name = "profit")
    val profit: Int
)