package com.example.ru_tube.domain

class Resource<T>(val data: T? = null, val message: String? = null, val status: Status) {
    enum class Status {
        SUCCESS, ERROR, LOADING
    }

    companion object{
        fun <T> success(data:T): Resource<T>{
            return Resource(data = data, status =  Status.SUCCESS)
        }

        fun <T> loading(): Resource<T>{
            return Resource(status = Status.LOADING)
        }

        fun <T> error(message: String) : Resource<T>{
            return Resource(data = null, message, status = Status.ERROR)
        }
    }
}