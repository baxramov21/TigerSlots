package com.sheikh.tigerslots.domain.usecases

import com.sheikh.tigerslots.domain.repository.GameRepository

class GenerateProfitUseCase(private val repository: GameRepository) {

    operator fun invoke() {
        repository.setProfit()
    }
}