package com.example.shcheprov_homeworks.di

import android.content.Context
import android.content.SharedPreferences
import com.example.shcheprov_homeworks.common.Keys
import dagger.Module
import dagger.Provides

@Module
class DataModule {
    @Provides
    fun provideSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(Keys.sharedPreferencesFileName, Context.MODE_PRIVATE)
    }
}