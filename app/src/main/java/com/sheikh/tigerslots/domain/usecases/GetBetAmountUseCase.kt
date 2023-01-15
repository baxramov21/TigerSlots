package com.sheikh.tigerslots.domain.usecases

import androidx.lifecycle.LiveData
import com.sheikh.tigerslots.domain.repository.GameRepository

class GetBetAmountUseCase(private val repository: GameRepository) {

    operator fun invoke(): LiveData<Int> = repository.getBetAmount()
}