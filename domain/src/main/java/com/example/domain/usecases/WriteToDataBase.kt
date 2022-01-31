package com.example.domain.usecases

import com.example.domain.contracts.IDataBaseWrite

class WriteToDataBase(val repository: IDataBaseWrite) {
    operator fun invoke(value: String) = repository.write(value)
}