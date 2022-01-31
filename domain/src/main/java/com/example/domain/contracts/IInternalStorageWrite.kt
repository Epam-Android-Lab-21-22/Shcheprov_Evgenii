package com.example.domain.contracts

interface IInternalStorageWrite {
    fun write(value: String, writeErrorCallback: () -> Unit)
}