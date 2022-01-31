package com.example.domain.contracts

interface IExternalStorageRead {
    fun read(callback: (String) -> Unit)
}