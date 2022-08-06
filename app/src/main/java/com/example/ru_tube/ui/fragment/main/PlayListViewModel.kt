package com.example.ru_tube.ui.fragment.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import com.example.ru_tube.core.base.viewmodel.BaseViewModel
import com.example.ru_tube.data.repo.Repository
import com.example.ru_tube.model.PlayList

class PlayListViewModel(private val repo: Repository) : BaseViewModel() {

    private val _playList = MutableLiveData<PlayList>()
    val playList = repo.getPlayList()

    val setPlayList = _playList.switchMap {
        repo.putPlayList(it)
    }

    fun setPlayList(playList: PlayList){
        _playList.postValue(playList)
    }
}