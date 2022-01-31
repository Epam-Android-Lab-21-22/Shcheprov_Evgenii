package com.example.shcheprov_homeworks.di


import com.example.shcheprov_homeworks.view.MainActivity
import dagger.Component
import javax.inject.Singleton
@Component(modules = [AppModule::class,DomainModule::class,DataModule::class])
@Singleton
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}