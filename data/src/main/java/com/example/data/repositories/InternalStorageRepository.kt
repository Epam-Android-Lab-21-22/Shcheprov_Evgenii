package com.example.data.repositories

import android.content.Context
import com.example.data.common.DefaultIds
import com.example.domain.contracts.IInternalStorageRead
import com.example.domain.contracts.IInternalStorageWrite
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File
import java.io.FileReader
import java.io.FileWriter
import java.lang.Exception

class InternalStorageRepository(private val context: Context) : IInternalStorageRead,
    IInternalStorageWrite {
    override fun read(callback: (String) -> Unit) {
        CoroutineScope(Dispatchers.IO).runCatching {
            try {
                val dir = context.filesDir
                val reader = FileReader(File(dir, DefaultIds.storageName))
                val result = reader.readText()
                reader.close()
                CoroutineScope(Dispatchers.Main).launch {
                    callback(result)
                }
            } catch (e: Exception) {
                CoroutineScope(Dispatchers.Main).launch {
                    callback("")
                }
            }

        }
    }

    override fun write(value: String, writeErrorCallback: () -> Unit) {
        CoroutineScope(Dispatchers.IO).runCatching {
            try {
                val dir = context.filesDir
                val writer = FileWriter(File(dir, DefaultIds.storageName))
                writer.apply {
                    append(value)
                    flush()
                    close()
                }
            } catch (e: Exception) {
                writeErrorCallback()
            }
        }
    }

}