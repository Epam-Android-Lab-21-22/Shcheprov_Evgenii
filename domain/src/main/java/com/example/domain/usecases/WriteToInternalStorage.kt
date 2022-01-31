package com.example.domain.usecases


import com.example.domain.contracts.IInternalStorageWrite

class WriteToInternalStorage(val repository: IInternalStorageWrite) {
    operator fun invoke(value: String, writeErrorCallback: () -> Unit) =
        repository.write(value, writeErrorCallback)
}