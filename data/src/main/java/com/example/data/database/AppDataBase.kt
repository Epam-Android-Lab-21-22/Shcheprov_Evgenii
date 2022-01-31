package com.example.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.data.common.DefaultIds

@Database(entities = [Text::class], version = 2, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {
    abstract fun storageDao(): StorageDAO

    companion object {
        private var INSTANCE: AppDataBase? = null
        fun getAppDataBase(context: Context): AppDataBase {
            if (INSTANCE == null) {
                synchronized(AppDataBase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context,
                            AppDataBase::class.java, DefaultIds.databaseName
                        )
                            .fallbackToDestructiveMigration()
                            .build()
                    }
                }
            }
            return INSTANCE!!
        }
    }
}