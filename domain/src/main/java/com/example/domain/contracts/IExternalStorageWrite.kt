package com.example.domain.contracts

interface IExternalStorageWrite {
    fun write(value: String, writeErrorCallback: () -> Unit)

}