package com.example.ru_tube.data.converter

import androidx.room.TypeConverter
import com.example.ru_tube.model.Item
import com.example.ru_tube.model.PageInfo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.*

object ItemsConverter {

    @TypeConverter
    fun storedStringToMyObjects(data:String?):List<Item?>? {
        val gson = Gson()
        if (data == null){
            return Collections.emptyList()
        }
        val listType: Type = object : TypeToken<List<Item?>?>() {}.type
        return gson.fromJson<List<Item?>>(data, listType)
    }


    @TypeConverter
    fun myObjectsToStoredString(myObject: List<Item?>?): String?{
        val gson = Gson()
        return gson.toJson(myObject)
    }

    @TypeConverter
    fun storedStringToMyPageInfo(data:String?): PageInfo? {
        val gson = Gson()
        return gson.fromJson(data, PageInfo::class.java)
    }


    @TypeConverter
    fun myPageInfoToStoredString(myObjects: PageInfo): String?{
        val gson = Gson()
        return gson.toJson(myObjects)
    }
}