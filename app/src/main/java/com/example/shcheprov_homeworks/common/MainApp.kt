package com.example.shcheprov_homeworks.common

import android.app.Application

open class MainApp : Application() {

    lateinit var mainAppStorage: MainAppStorage
    override fun onCreate() {
        super.onCreate()
        mainAppStorage = MainAppStorage()
        mainAppStorage.initialize()
    }
}




