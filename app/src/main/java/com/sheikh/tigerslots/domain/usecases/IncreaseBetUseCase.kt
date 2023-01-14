package com.sheikh.tigerslots.domain.usecases

import com.sheikh.tigerslots.domain.repository.GameRepository

class IncreaseBetUseCase(private val repository: GameRepository) {

    operator fun invoke(upValue: Int) {
        repository.increaseBet(upValue)
    }
}