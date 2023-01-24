package com.sheikh.tigerslots.domain.usecases

import com.sheikh.tigerslots.domain.repository.GameRepository

class UpdateDepositUseCase(private val repository: GameRepository) {

    operator fun invoke() {
        repository.updateDeposit()
    }
}