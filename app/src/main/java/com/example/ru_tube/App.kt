package com.example.ru_tube

import android.app.Application
import com.example.ru_tube.data.local.Database
import androidx.room.Room

class App: Application() {

    companion object{
        lateinit var database: Database
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(applicationContext, Database::class.java, "db").build()
    }
}