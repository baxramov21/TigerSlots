package com.sheikh.tigerslots.domain.usecases

import com.sheikh.tigerslots.domain.repository.GameRepository

class SetWinStateUseCase(private val repository: GameRepository) {

    operator fun invoke(win: Boolean) {
        repository.setWinState(win)
    }
}