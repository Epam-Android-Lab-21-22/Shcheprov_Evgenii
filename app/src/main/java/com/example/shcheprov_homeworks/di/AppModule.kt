package com.example.shcheprov_homeworks.di

import android.content.Context
import com.example.data.repositories.DataBaseRepository
import com.example.data.repositories.ExternalStorageRepository
import com.example.data.repositories.InternalStorageRepository
import com.example.data.repositories.SharedPreferencesRepository
import com.example.domain.usecases.*
import com.example.shcheprov_homeworks.viewmodels.MainViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val context: Context) {

    @Provides
    fun provideContext(): Context {
        return context
    }

    @Provides
    fun provideSaveToSharedPreferences(sharedPreferencesRepository: SharedPreferencesRepository): SaveToSharedPreferences {
        return SaveToSharedPreferences(sharedPreferencesRepository)
    }

    @Provides
    fun provideLoadFromSharedPreferences(sharedPreferencesRepository: SharedPreferencesRepository): LoadFromSharedPreferences {
        return LoadFromSharedPreferences(sharedPreferencesRepository)
    }

    @Provides
    fun provideWriteToInternalStorage(internalStorageRepository: InternalStorageRepository): WriteToInternalStorage {
        return WriteToInternalStorage(internalStorageRepository)
    }

    @Provides
    fun provideReadFromInternalStorage(internalStorageRepository: InternalStorageRepository): ReadFromInternalStorage {
        return ReadFromInternalStorage(internalStorageRepository)
    }

    @Provides
    fun provideReadFromExternalStorage(externalStorageRepository: ExternalStorageRepository): ReadFromExternalStorage {
        return ReadFromExternalStorage(externalStorageRepository)
    }

    @Provides
    fun provideWriteToExternalStorage(externalStorageRepository: ExternalStorageRepository): WriteToExternalStorage {
        return WriteToExternalStorage(externalStorageRepository)
    }

    @Provides
    fun provideWriteToDataBase(repository: DataBaseRepository): WriteToDataBase {
        return WriteToDataBase(repository)
    }

    @Provides
    fun provideReadFromDataBase(repository: DataBaseRepository): ReadFromDataBase {
        return ReadFromDataBase(repository)
    }

    @Provides
    fun provideViewModelFactory(
        saveToSharedPreferences: SaveToSharedPreferences,
        loadFromSharedPreferences: LoadFromSharedPreferences,
        writeToInternalStorage: WriteToInternalStorage,
        readFromInternalStorage: ReadFromInternalStorage,
        writeToExternalStorage: WriteToExternalStorage,
        readFromExternalStorage: ReadFromExternalStorage,
        writeToDataBase: WriteToDataBase,
        readFromDataBase: ReadFromDataBase
    ): MainViewModelFactory {
        return MainViewModelFactory(
            saveToSharedPreferences,
            loadFromSharedPreferences,
            writeToInternalStorage,
            readFromInternalStorage,
            writeToExternalStorage,
            readFromExternalStorage,
            writeToDataBase,
            readFromDataBase
        )
    }
}