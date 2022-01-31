package com.example.domain.contracts

interface IInternalStorageRead {
    fun read(callback: (String) -> Unit)
}