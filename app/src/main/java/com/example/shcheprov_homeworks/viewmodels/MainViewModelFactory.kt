package com.example.shcheprov_homeworks.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.usecases.*

class MainViewModelFactory(
    private val saveToSharedPreferences: SaveToSharedPreferences,
    private val loadFromSharedPreferences: LoadFromSharedPreferences,
    private val writeToInternalStorage: WriteToInternalStorage,
    private val readFromInternalStorage: ReadFromInternalStorage,
    private val writeToExternalStorage: WriteToExternalStorage,
    private val readFromExternalStorage: ReadFromExternalStorage,
    private val writeToDataBase: WriteToDataBase,
    private val readFromDataBase: ReadFromDataBase
) :ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainActivityViewModel(  saveToSharedPreferences,
            loadFromSharedPreferences,
            writeToInternalStorage,
            readFromInternalStorage,
            writeToExternalStorage,
            readFromExternalStorage,
            writeToDataBase,
            readFromDataBase) as T
    }
}