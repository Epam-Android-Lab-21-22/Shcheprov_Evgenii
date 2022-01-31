package com.example.domain.usecases

import com.example.domain.contracts.IExternalStorageRead

class ReadFromExternalStorage(val repository:IExternalStorageRead) {
    operator fun invoke(callback: (String) -> Unit) = repository.read(callback)
}