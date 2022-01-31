package com.example.domain.usecases

import com.example.domain.contracts.IDataBaseRead

class ReadFromDataBase(val repository: IDataBaseRead) {
    operator fun invoke(callback: (String) -> Unit) = repository.read(callback)
}