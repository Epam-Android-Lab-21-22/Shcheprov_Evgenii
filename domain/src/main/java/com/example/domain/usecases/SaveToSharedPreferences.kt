package com.example.domain.usecases

import com.example.domain.contracts.ISharedPreferencesSave

class SaveToSharedPreferences(private val repository: ISharedPreferencesSave) {
    operator fun invoke(key: String, value: String) = repository.save(key, value)
}