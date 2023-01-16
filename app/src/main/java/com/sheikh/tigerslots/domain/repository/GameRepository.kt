package com.sheikh.tigerslots.domain.repository

import androidx.lifecycle.LiveData
import com.sheikh.tigerslots.domain.entities.GameData

interface GameRepository {

    fun getBetAmount(): LiveData<Int>

    fun getDeposit(): LiveData<Int>

    fun getWinAmount(): LiveData<Int>

    fun increaseBet(upValue: Int)

    fun startGame(
        listOfImageIDs: List<Int>,
        listOfImageViewPositions: List<Int>
    ): List<Int>

    fun setDeposit(updatedDeposit: Int)

    fun setProfit(profit: Int)

    fun setWinState(win: Boolean)
}