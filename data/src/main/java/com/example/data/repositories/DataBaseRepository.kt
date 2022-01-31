package com.example.data.repositories

import com.example.data.common.DefaultIds
import com.example.data.database.Text
import com.example.data.database.AppDataBase
import com.example.domain.contracts.IDataBaseRead
import com.example.domain.contracts.IDataBaseWrite
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DataBaseRepository(dataBase: AppDataBase) : IDataBaseRead, IDataBaseWrite {
    private val dao = dataBase.storageDao()

    override fun read(callback: (String) -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            val result = dao.getTextById(DefaultIds.defaultId)
            CoroutineScope(Dispatchers.Main).launch {
                callback(result.value)
            }
        }
    }

    override fun write(value: String) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.insertText(Text(DefaultIds.defaultId, value))
        }
    }
}