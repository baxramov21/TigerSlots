package com.sheikh.tigerslots.domain.usecases

import com.sheikh.tigerslots.domain.repository.GameRepository

class SetDepositUseCase(private val repository: GameRepository) {

    operator fun invoke(updatedDeposit: Int) {
        repository.setDeposit(updatedDeposit)
    }
}