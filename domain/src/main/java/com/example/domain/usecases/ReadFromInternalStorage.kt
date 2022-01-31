package com.example.domain.usecases

import com.example.domain.contracts.IInternalStorageRead

class ReadFromInternalStorage(val repository:IInternalStorageRead) {
    operator fun invoke(callback: (String) -> Unit) = repository.read(callback)
}