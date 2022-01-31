package com.example.data.repositories


import android.content.SharedPreferences
import androidx.core.content.edit

import com.example.domain.contracts.ISharedPreferencesLoad
import com.example.domain.contracts.ISharedPreferencesSave

class SharedPreferencesRepository(private val sharedPreferences: SharedPreferences) :
    ISharedPreferencesSave, ISharedPreferencesLoad {
    override fun load(key: String): String = sharedPreferences.getString(key, "")!!
    
    override fun save(key: String, value: String) {
        sharedPreferences.edit {
            putString(key, value)
        }
    }
}