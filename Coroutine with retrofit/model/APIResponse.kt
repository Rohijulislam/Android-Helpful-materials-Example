package com.example.firstapplication.model

sealed class APIResponse<T> {
    class Success<T>(val data : T) : APIResponse<T>()
    class Error<T>(val msg: String, val data: T? = null) : APIResponse<T>()
    class Loading<T>(val data : T? = null) : APIResponse<T>()


}

