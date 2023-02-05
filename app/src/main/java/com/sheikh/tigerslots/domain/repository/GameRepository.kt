package com.sheikh.tigerslots.domain.repository

import androidx.lifecycle.LiveData
import com.sheikh.tigerslots.domain.entities.GameData

interface GameRepository {

    fun getBetAmount(): LiveData<Int>

    fun getDeposit(): LiveData<Int>

    fun getWinAmount(): LiveData<Int>

    fun increaseBet(betAmount: Int)

    fun startGame(listOfImageIDs: List<Int>): List<Int>

    fun updateDeposit()

    fun setProfit()

    fun setWinState(win: Boolean)
}