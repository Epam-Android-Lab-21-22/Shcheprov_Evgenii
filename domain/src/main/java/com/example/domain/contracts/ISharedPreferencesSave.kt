package com.example.domain.contracts

interface ISharedPreferencesSave {
    fun save(key: String, value: String)
}