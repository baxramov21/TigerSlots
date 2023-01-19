package com.sheikh.tigerslots.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.sheikh.tigerslots.data.db_models.*
import com.sheikh.tigerslots.domain.entities.GameData

@Dao
interface GameDao {

    @Query("SELECT * FROM game_data_table")
    fun getGameData(): LiveData<GameDataDbModel>

    @Query("SELECT * FROM deposit_table")
    fun getDeposit(): LiveData<DepositDbModel>

    @Query("SELECT * FROM bet_table")
    fun getBet(): LiveData<BetAmountDbModel>

    @Query("SELECT * FROM wins_table")
    fun getWinState(): LiveData<WinStateDbModel>

    @Query("SELECT * FROM profit_table")
    fun getProfit(): LiveData<ProfitAmountDbModel>

    @Insert()
    fun setGameData(gameData: GameDataDbModel)

    @Insert
    fun setDeposit(depositDbModel: DepositDbModel)

    @Insert
    fun setBet(betAmountDbModel: BetAmountDbModel)

    @Insert
    fun setWin(winStateDbModel: WinStateDbModel)

    @Insert
    fun setProfit(profitAmountDbModel: ProfitAmountDbModel)
}