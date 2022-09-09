package com.freedasd.retrofit.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MovieDb::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun dao() : Dao

    companion object {

        @Volatile
        private var INSTANCE : AppDataBase? = null

        fun localDataBase(context: Context) : AppDataBase {
            val tempIstance = INSTANCE
            if (tempIstance != null) return tempIstance

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "app_dataBase"
                )
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}