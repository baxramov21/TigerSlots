package com.sheikh.tigerslots.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Transformations
import com.sheikh.tigerslots.data.db.*
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
            mapper.mapDepositToEntity(it)
        }

    override fun getWinAmount(): LiveData<Int> =
        Transformations.map(db.getProfit()) {
            mapper.mapDbModelToEntity(it)
        }

    override fun setDeposit(updatedDeposit: Int) {
        val newDeposit = DepositDbModel(deposit = updatedDeposit)
        db.setDeposit(newDeposit)
    }

    override fun setWinState(win: Boolean) {
        val winState = WinStateDbModel(win = win)
        db.setWin(winState)
    }

    override fun setProfit(profit: Int) {
        val profitAmount = ProfitAmountDbModel(profit = profit)
        db.setProfit(profitAmount)
    }

    override fun increaseBet(upValue: Int) {
        getBetAmount().value?.let {
            val newBetAmount = it + 1
            val newBetValue = BetAmountDbModel(bet = newBetAmount)
            db.setBet(newBetValue)
        }
    }

    override fun startGame(
        listOfImageIDs: List<Int>,
        listOfImageViewPositions: List<Int>
    ): List<Int> {
        val result = mutableListOf<Int>()
        if (listOfImageIDs.size == listOfImageViewPositions.size) {
            for (position in listOfImageViewPositions) {
                result.add(position - 1, listOfImageIDs.random())
            }
        }
        return result
    }

    fun mergeLiveData(liveData: LiveData<Int>) = MediatorLiveData<Int>().apply {
        addSource(liveData) {
            value = it
        }
    }

}