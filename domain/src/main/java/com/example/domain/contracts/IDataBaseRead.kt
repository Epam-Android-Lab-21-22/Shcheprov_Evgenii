package com.example.domain.contracts

interface IDataBaseRead {
    fun read(callback: (String) -> Unit)
}