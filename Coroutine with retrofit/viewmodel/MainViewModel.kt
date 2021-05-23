package com.example.firstapplication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.firstapplication.apiservices.APIService
import com.example.firstapplication.model.APIResponse
import kotlinx.coroutines.Dispatchers

class MainViewModel : ViewModel() {

    fun getUsers() = liveData(Dispatchers.IO) {
        emit(APIResponse.Loading(null))
        try {
            emit(APIResponse.Success(APIService.getUsers()))
        } catch (exception: Exception) {
            emit(APIResponse.Error(data = null, msg = exception.message ?: "Error Occurred!"))
        }
    }

}