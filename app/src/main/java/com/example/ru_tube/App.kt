package com.example.ru_tube

import android.app.Application
import com.example.ru_tube.data.network.NetworkModule
import com.example.ru_tube.di.databaseModule
import com.example.ru_tube.di.repoModule
import com.example.ru_tube.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(repoModule, viewModelModule, NetworkModule, databaseModule))
        }
    }
}