package com.sheikh.tigerslots.data.db

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sheikh.tigerslots.data.db_models.*

@Database(entities = [GameDataDbModel::class, DepositDbModel::class, BetAmountDbModel::class, WinStateDbModel::class, ProfitAmountDbModel::class], version = 1, exportSchema = false)
abstract class GameDatabase : RoomDatabase() {

    abstract fun getDao(): GameDao

    companion object {

        private val DB_NAME: String = "game.db"
        private var INSTANCE: GameDatabase? = null
        private val LOCK = Any()

        fun getInstance(application: Application): GameDatabase {
            INSTANCE?.let {
                return it
            }
            synchronized(LOCK) {
                INSTANCE?.let {
                    return it
                }
                val db =
                    Room.databaseBuilder(
                        application,
                        GameDatabase::class.java,
                        DB_NAME
                    ).build()
                INSTANCE = db
                return db
            }
        }
    }
}