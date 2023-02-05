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
import kotlin.random.Random

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

    private fun getLDValue(liveData: LiveData<Int>): Int {
        val result = liveData.value
        return result ?: 0
    }

    override fun updateDeposit() {
        val deposit = getLDValue(getDeposit())
        val betAmount = getLDValue(getBetAmount())
        val profit = getLDValue(getWinAmount())
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

    override fun setProfit() {
        val win = Random.nextBoolean()
        val randomProfit = if (win) {
            Random.nextInt(MIN_PROFIT_AMOUNT, MAX_PROFIT_AMOUNT)
        } else {
            BET_LOST

        }
        val profitAmount = ProfitAmountDbModel(profit = randomProfit)
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
        private const val BET_LOST = 0
        private const val MIN_PROFIT_AMOUNT = 10
        private const val MAX_PROFIT_AMOUNT = 60
    }
}