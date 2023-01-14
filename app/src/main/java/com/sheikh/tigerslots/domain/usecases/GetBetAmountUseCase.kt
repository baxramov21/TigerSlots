package com.sheikh.tigerslots.domain.usecases

import com.sheikh.tigerslots.domain.repository.GameRepository

class GetBetAmountUseCase(private val repository: GameRepository) {

    operator fun invoke(): Int = repository.getBetAmount()
}