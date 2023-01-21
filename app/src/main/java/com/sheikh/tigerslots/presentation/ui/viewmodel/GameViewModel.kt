package com.sheikh.tigerslots.presentation.ui.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sheikh.tigerslots.data.GameRepositoryImpl
import com.sheikh.tigerslots.domain.usecases.*

class GameViewModel(private val application: Application) : ViewModel() {

    private val repository = GameRepositoryImpl(application)

    private val getDepositUseCase = GetDepositUseCase(repository)
    private val getBetAmountUseCase = GetBetAmountUseCase(repository)
    private val getWinAmountUseCase = GetWinAmountUseCase(repository)

    private val setDepositUseCase = SetDepositUseCase(repository)
    private val setProfitUseCase = SetProfitUseCase(repository)
    private val setWinStateUseCase = SetWinStateUseCase(repository)

    private val increaseBetUseCase = IncreaseBetUseCase(repository)
    private val startGameUseCase = StartGameUseCase(repository)

    private val _deposit = MutableLiveData<Int>()
    val deposit: LiveData<Int>
        get() = _deposit

    private val _betAmount = MutableLiveData<Int>()
    val betAmount: LiveData<Int>
        get() = _betAmount

    private val _winAmount = MutableLiveData<Int>()
    val winAmount: LiveData<Int>
        get() = _winAmount

    private fun getData() {
        _deposit.value = getDepositUseCase().value
        _betAmount.value = getBetAmountUseCase().value
        _winAmount.value = getWinAmountUseCase().value
    }

    init {
        setNewDeposit(100)
        increaseBet(10)
        getData()
    }

    fun setNewDeposit(newDeposit: Int) {
        setDepositUseCase(newDeposit)
    }

    fun setProfit(profit: Int) {
        setProfitUseCase(profit)
    }

    fun increaseBet(newBet: Int) {
        increaseBetUseCase(newBet)
    }

    fun setWinState(win: Boolean) {
        setWinStateUseCase(win)
    }

    fun startGame(listOfImageIDs: List<Int>): List<Int> {
        return startGameUseCase(listOfImageIDs)
    }

    override fun onCleared() {
        super.onCleared()
    }
}