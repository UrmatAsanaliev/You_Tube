package com.example.ru_tube.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.ru_tube.data.converter.ItemsConverter
import com.example.ru_tube.model.PlayList

@Database(entities = [PlayList::class], version = 1)
@TypeConverters(ItemsConverter::class)
abstract class Database : RoomDatabase(){
    abstract fun dao(): Dao
}