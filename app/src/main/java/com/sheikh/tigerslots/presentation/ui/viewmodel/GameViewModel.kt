package com.sheikh.tigerslots.presentation.ui.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import com.sheikh.tigerslots.data.GameRepositoryImpl
import com.sheikh.tigerslots.domain.usecases.*

class GameViewModel(private val application: Application) : ViewModel() {

    private val repository = GameRepositoryImpl(application)

    private val getDepositUseCase = GetDepositUseCase(repository)
    private val getBetAmountUseCase = GetBetAmountUseCase(repository)
    private val getWinAmountUseCase = GetWinAmountUseCase(repository)

    private val updateDepositUseCase = UpdateDepositUseCase(repository)
    private val setProfitUseCase = SetProfitUseCase(repository)
    private val setWinStateUseCase = SetWinStateUseCase(repository)

    private val increaseBetUseCase = IncreaseBetUseCase(repository)
    private val startGameUseCase = StartGameUseCase(repository)

    val deposit = getDepositUseCase()
    val betAmount = getBetAmountUseCase()
    val profit = getWinAmountUseCase()

    private var bet = 10


    fun updateDeposit() {
        updateDepositUseCase()
    }

    fun setProfit(profit: Int) {
        setProfitUseCase(profit)
    }

    fun increaseBet() {
        bet++
        increaseBetUseCase.invoke(bet)
    }

    fun setWinState(win: Boolean) {
        setWinStateUseCase(win)
    }

    fun startGame(listOfImageIDs: List<Int>): List<Int> {
        return startGameUseCase(listOfImageIDs)
    }
}