package com.example.ru_tube.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.ru_tube.model.PlayList

@Dao
interface Dao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(playList: PlayList)

    @Query("SELECT * FROM playlist")
    fun getPlayList():LiveData<PlayList>
}