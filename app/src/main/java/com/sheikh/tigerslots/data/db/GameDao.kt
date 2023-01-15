package com.sheikh.tigerslots.data.db

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.Query
import com.sheikh.tigerslots.domain.entities.GameData

interface GameDao {
    @Query("SELECT deposit FROM game_data_table")
    fun getDeposit(): LiveData<Int>

    @Query("SELECT bet FROM game_data_table")
    fun getBet(): LiveData<Int>

    @Query("SELECT win FROM game_data_table")
    fun getWin(): LiveData<Int>

    @Query("SELECT profit FROM game_data_table")
    fun getProfit(): LiveData<Int>

    @Insert()
    fun setGameData(gameData: GameData)
}