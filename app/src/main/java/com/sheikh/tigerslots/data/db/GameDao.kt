package com.sheikh.tigerslots.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.sheikh.tigerslots.data.db_models.*

@Dao
interface GameDao {

    @Query("SELECT * FROM game_data_table")
    fun getGameData(): LiveData<GameDataDbModel>

    @Query("SELECT * FROM deposit_table ORDER BY id DESC LIMIT 1")
    fun getDeposit(): LiveData<DepositDbModel>

    @Query("SELECT * FROM wins_table")
    fun getWinState(): LiveData<WinStateDbModel>

    @Query("SELECT * FROM bet_table ORDER BY id DESC LIMIT 1")
    fun getBet(): LiveData<BetAmountDbModel>

    @Query("SELECT * FROM profit_table")
    fun getProfit(): LiveData<ProfitAmountDbModel>

    @Insert()
    fun setGameData(gameData: GameDataDbModel)

    @Upsert
    fun setDeposit(newDepositDbModel: DepositDbModel)

    @Upsert
    fun setBet(betAmountDbModel: BetAmountDbModel)

    @Upsert
    fun setWin(winStateDbModel: WinStateDbModel)

    @Upsert
    fun setProfit(profitAmountDbModel: ProfitAmountDbModel)
}