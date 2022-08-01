package com.example.ru_tube.core.base.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel: ViewModel(){
    val progress = MutableLiveData<Boolean>()
    var splash: MutableLiveData<Boolean>? = null
}