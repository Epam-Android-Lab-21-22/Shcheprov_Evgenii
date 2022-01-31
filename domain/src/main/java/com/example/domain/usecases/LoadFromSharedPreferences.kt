package com.example.domain.usecases

import com.example.domain.contracts.ISharedPreferencesLoad

class LoadFromSharedPreferences(private val repository: ISharedPreferencesLoad) {
    operator fun invoke(key: String) = repository.load(key)
}