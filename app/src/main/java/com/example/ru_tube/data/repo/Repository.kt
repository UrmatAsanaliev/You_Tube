package com.example.ru_tube.data.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.ru_tube.App
import com.example.ru_tube.data.network.RetrofitClient
import com.example.ru_tube.domain.Resource
import com.example.ru_tube.model.PlayList
import kotlinx.coroutines.Dispatchers

class Repository {
    private val apiService = RetrofitClient.create()

    fun getPlayList(): LiveData<Resource<PlayList?>> = liveData(Dispatchers.IO){
        val result = apiService.getPLayList()
        emit(Resource.loading())
        if(result.isSuccessful){
            emit(Resource.success(result.body()))
        } else{
            emit(Resource.error(result.message()))
        }
    }

    fun putPlayList(playList : PlayList): LiveData<Boolean> = liveData(Dispatchers.IO) {
        App.database.dao().insert(playList)
    }



}