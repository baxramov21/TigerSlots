package com.sheikh.tigerslots.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.sheikh.tigerslots.data.db.GameDatabase
import com.sheikh.tigerslots.data.db_models.BetAmountDbModel
import com.sheikh.tigerslots.data.db_models.DepositDbModel
import com.sheikh.tigerslots.data.db_models.ProfitAmountDbModel
import com.sheikh.tigerslots.data.db_models.WinStateDbModel
import com.sheikh.tigerslots.data.mappers.Mapper
import com.sheikh.tigerslots.domain.repository.GameRepository

class GameRepositoryImpl(application: Application) : GameRepository {

    private val db = GameDatabase.getInstance(application).getDao()
    private val mapper = Mapper()

    override fun getBetAmount(): LiveData<Int> =
        Transformations.map(db.getBet()) {
            mapper.mapDbModelToEntity(it)
        }

    override fun getDeposit(): LiveData<Int> =
        Transformations.map(db.getDeposit()) {
            mapper.mapDbModelToEntity(it)
        }

    override fun getWinAmount(): LiveData<Int> =
        Transformations.map(db.getProfit()) {
            mapper.mapDbModelToEntity(it)
        }

    private fun setDeposit(updatedDeposit: Int) {
        val newDeposit = DepositDbModel(deposit = updatedDeposit)
        db.setDeposit(newDeposit)
    }

    override fun updateDeposit() {
        val deposit = getDeposit().value
        val betAmount = getBetAmount().value
        val profit = getWinAmount().value
        if (deposit != null && betAmount != null &&
            profit != null
        ) {
            val newDeposit = (deposit - betAmount) + profit
            setDeposit(newDeposit)
        } else if (deposit == null) {
            setDeposit(100)
        }
    }

    override fun setWinState(win: Boolean) {
        val winState = WinStateDbModel(win = win)
        db.setWin(winState)
    }

    override fun setProfit(profit: Int) {
        val profitAmount = ProfitAmountDbModel(profit = profit)
        db.setProfit(profitAmount)
    }

    override fun increaseBet(betAmount: Int) {
        db.setBet(BetAmountDbModel(bet = betAmount))
    }

    override fun startGame(
        listOfImageIDs: List<Int>
    ): List<Int> {
        val result = mutableListOf<Int>()
        for (position in listOfImageIDs) {
            result.add(listOfImageIDs.random())
        }
        return result
    }

    companion object {
        private const val DEFAULT_BET_AMOUNT = 10
    }
}