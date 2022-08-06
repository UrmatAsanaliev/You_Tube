package com.example.ru_tube.di

import android.accounts.AccountManager.get
import android.content.Context
import androidx.room.Room
import com.example.ru_tube.data.local.Database
import org.koin.dsl.module

val databaseModule = module {
    single{provideDatabase(get())}
}

fun provideDatabase(context: Context): Database {
    return Room.databaseBuilder(context, Database::class.java, "db").build()
}