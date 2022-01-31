package com.example.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface StorageDAO {
    @Query("SELECT * FROM Text WHERE id==:id")
    suspend fun getTextById(id: Int): Text

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertText(text: Text)
}