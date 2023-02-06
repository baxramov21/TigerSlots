package com.sheikh.tigerslots.presentation.ui.viewmodel

import android.app.Application
import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sheikh.tigerslots.data.GameRepositoryImpl
import com.sheikh.tigerslots.domain.usecases.*

class GameViewModel(private val application: Application) : ViewModel() {

    private val repository = GameRepositoryImpl(application)

    private val getDepositUseCase = GetDepositUseCase(repository)
    private val getBetAmountUseCase = GetBetAmountUseCase(repository)
    private val getWinAmountUseCase = GetWinAmountUseCase(repository)

    private val updateDepositUseCase = UpdateDepositUseCase(repository)
    private val generateProfitUseCase = GenerateProfitUseCase(repository)
    private val setWinStateUseCase = SetWinStateUseCase(repository)

    private val increaseBetUseCase = IncreaseBetUseCase(repository)
    private val startGameUseCase = StartGameUseCase(repository)

    private val _imagesList = MutableLiveData<List<Int>>()
    val imageList: LiveData<List<Int>>
        get() = _imagesList

    private val _gameFinished = MutableLiveData<Boolean>()
    val gameFinished: LiveData<Boolean>
        get() = _gameFinished

    private var firstStart = true

    val deposit = getDepositUseCase()
    val betAmount = getBetAmountUseCase()
    val profit = getWinAmountUseCase()

    private var bet = 10

    init {
        if (firstStart) {
            firstStart = false
            updateDeposit(100, 0)
            increaseBet()
            generateProfit()
        }
    }

    fun updateDeposit(deposit: Int, profit: Int) {
        updateDepositUseCase(deposit, bet, profit)
    }

    fun generateProfit() {
        generateProfitUseCase()
    }

    fun increaseBet() {
        bet++
        increaseBetUseCase(bet)
    }

    fun setWinState(win: Boolean) {
        setWinStateUseCase(win)
    }

    fun startGame(listOfImageIDs: List<Int>) {
        val timer = object : CountDownTimer(
            GAME_LENGTH_IN_SECONDS * 1000,
            SLOTS_GENERATION_INTERVAL_IN_MILLI_SECONDS
        ) {
            override fun onTick(p0: Long) {
                _gameFinished.postValue(false)
                _imagesList.postValue(startGameUseCase(listOfImageIDs))
            }

            override fun onFinish() {
                _imagesList.postValue(startGameUseCase(listOfImageIDs))
                _gameFinished.postValue(true)
            }
        }
        timer.start()
    }

    companion object {
        private const val GAME_LENGTH_IN_SECONDS = 4L
        private const val SLOTS_GENERATION_INTERVAL_IN_MILLI_SECONDS = 120L
    }
}