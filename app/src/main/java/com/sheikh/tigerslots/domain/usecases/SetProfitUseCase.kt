package com.sheikh.tigerslots.domain.usecases

import com.sheikh.tigerslots.domain.repository.GameRepository

class SetProfitUseCase(private val repository: GameRepository) {

    operator fun invoke(profit: Int) {
        repository.setProfit(profit)
    }
}