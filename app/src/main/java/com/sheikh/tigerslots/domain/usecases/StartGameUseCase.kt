package com.sheikh.tigerslots.domain.usecases

import com.sheikh.tigerslots.domain.entities.GameData
import com.sheikh.tigerslots.domain.repository.GameRepository

class StartGameUseCase(private val repository: GameRepository) {

    operator fun invoke(gameData: GameData) {
        repository.startGame(gameData)
    }
}