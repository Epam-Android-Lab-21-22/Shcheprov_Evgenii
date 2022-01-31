package com.example.shcheprov_homeworks.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.usecases.*
import com.example.shcheprov_homeworks.common.Keys

class MainActivityViewModel(
    val saveToSharedPreferences: SaveToSharedPreferences,
    val loadFromSharedPreferences: LoadFromSharedPreferences,
    val writeToInternalStorage: WriteToInternalStorage,
    val readFromInternalStorage: ReadFromInternalStorage,
    val writeToExternalStorage: WriteToExternalStorage,
    val readFromExternalStorage: ReadFromExternalStorage,
    val writeToDataBase: WriteToDataBase,
    val readFromDataBase: ReadFromDataBase
) : ViewModel() {

    private val _showWriteErrorToast = SingleLiveEvent<Any>()
    val showWriteErrorToast: LiveData<Any> = _showWriteErrorToast

    private val _textLiveData = MutableLiveData<String>()
    val textLiveData: LiveData<String> = _textLiveData

    fun saveStringToSharedPreferences(value: String) {
        saveToSharedPreferences(Keys.sharedPreferencesKey, value)
    }

    fun readStringFromSharedPreferences() {
        _textLiveData.value = loadFromSharedPreferences(Keys.sharedPreferencesKey)
    }

    fun saveStringToInternalStorage(value: String) {
        writeToInternalStorage(value, ::showWriteErrorToast)
    }

    fun readStringFromInternalStorage() {
        readFromInternalStorage(::updateTextLiveData)
    }

    fun saveStringToExternalStorage(value: String) {
        writeToExternalStorage(value, ::showWriteErrorToast)
    }

    fun readStringFromExternalStorage() {
        readFromExternalStorage(::updateTextLiveData)
    }

    fun saveStringToDataBase(value: String) {
        writeToDataBase(value)
    }

    fun readStringFromDataBase() {
        readFromDataBase(::updateTextLiveData)
    }

    private fun updateTextLiveData(value: String) {
        _textLiveData.value = value
    }

    private fun showWriteErrorToast() {
        _showWriteErrorToast.call()
    }
}