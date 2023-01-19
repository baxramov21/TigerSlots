package com.sheikh.tigerslots.domain.usecases

import com.sheikh.tigerslots.domain.entities.GameData
import com.sheikh.tigerslots.domain.repository.GameRepository

class StartGameUseCase(private val repository: GameRepository) {

    operator fun invoke(listOfImageIDs: List<Int>)
            : List<Int> {
        return repository.startGame(listOfImageIDs)
    }
}