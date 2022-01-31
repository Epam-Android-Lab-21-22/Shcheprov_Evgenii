package com.example.shcheprov_homeworks.di

import android.content.Context
import android.content.SharedPreferences
import com.example.data.database.AppDataBase
import com.example.data.repositories.DataBaseRepository
import com.example.data.repositories.ExternalStorageRepository
import com.example.data.repositories.InternalStorageRepository
import com.example.data.repositories.SharedPreferencesRepository
import dagger.Module
import dagger.Provides

@Module
class DomainModule {
    @Provides
    fun provideSharedPreferencesRepository(sharedPreferences: SharedPreferences): SharedPreferencesRepository {
        return SharedPreferencesRepository(sharedPreferences)
    }

    @Provides
    fun provideInternalStorageRepository(context: Context): InternalStorageRepository {
        return InternalStorageRepository(context)
    }

    @Provides
    fun provideExternalStorageRepository(context: Context): ExternalStorageRepository {
        return ExternalStorageRepository(context)
    }

    @Provides
    fun provideDataBaseRepository(context: Context): DataBaseRepository {
        return DataBaseRepository(AppDataBase.getAppDataBase(context))
    }
}