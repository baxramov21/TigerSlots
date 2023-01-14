package com.sheikh.tigerslots.domain.repository

import com.sheikh.tigerslots.domain.entities.GameData

interface GameRepository {

    fun getBetAmount(): Int

    fun getDeposit(): Int

    fun getWinAmount(): Int

    fun increaseBet(upValue: Int)

    fun startGame(gameData: GameData)
}