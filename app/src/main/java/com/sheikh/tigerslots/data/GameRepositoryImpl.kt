package com.sheikh.tigerslots.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Transformations
import com.sheikh.tigerslots.data.db.BetAmountDbModel
import com.sheikh.tigerslots.data.db.GameDataDbModel
import com.sheikh.tigerslots.data.db.GameDatabase
import com.sheikh.tigerslots.domain.entities.GameData
import com.sheikh.tigerslots.domain.repository.GameRepository

class GameRepositoryImpl(application: Application) : GameRepository {

    private val db = GameDatabase.getInstance(application).getDao()

    override fun getBetAmount(): LiveData<Int> {
        return db.getBet()
    }

    override fun getDeposit(): LiveData<Int> {
        return db.getDeposit()
    }

    override fun getWinAmount(): LiveData<Int> {
        return db.getProfit()
    }

    override fun increaseBet(upValue: Int) {
        getBetAmount().value?.let {
            val newBetAmount = it + 1
            val newBetValue = BetAmountDbModel(newBetAmount)
            db.setBet(newBetValue)
        }
    }

    override fun startGame(gameData: GameData) {

    }
}