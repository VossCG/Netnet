package com.example.netnet.remote

sealed class ResponseResult<out T> {
    data class Success<out T>(val data: T) : ResponseResult<T>()
    data class Error(val exception: Throwable) : ResponseResult<Nothing>()
    object Loading : ResponseResult<Nothing>()
}