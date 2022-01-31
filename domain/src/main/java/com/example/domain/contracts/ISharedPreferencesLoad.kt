package com.example.domain.contracts

interface ISharedPreferencesLoad {
    fun load(key: String): String
}