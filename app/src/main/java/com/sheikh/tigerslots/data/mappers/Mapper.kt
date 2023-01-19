package com.sheikh.tigerslots.data.mappers

import com.sheikh.tigerslots.data.db_models.*
import com.sheikh.tigerslots.domain.entities.GameData

class Mapper {

    fun mapDbModelToEntity(dbModel: DbModelInstance): Int {
        return dbModel.dbModelValue
    }

    fun mapDepositToEntity(depositDbModel: DepositDbModel): Int {
        return depositDbModel.deposit
    }


    fun mapWinStateToEntity(winStateDbModel: WinStateDbModel): Boolean {
        return winStateDbModel.win
    }

    fun mapGameDataToEntity(gameDataDbModel: GameDataDbModel): GameData {
        return GameData(
            gameDataDbModel.deposit,
            gameDataDbModel.bet,
            gameDataDbModel.win,
            gameDataDbModel.profit
        )
    }
}