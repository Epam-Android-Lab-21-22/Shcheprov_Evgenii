package com.example.domain.usecases

import com.example.domain.contracts.IExternalStorageWrite

class WriteToExternalStorage(val repository: IExternalStorageWrite) {
    operator fun invoke(value: String, writeErrorCallback: () -> Unit) =
        repository.write(value, writeErrorCallback)
}