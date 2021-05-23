package com.example.firstapplication.apiservices

import com.example.firstapplication.model.User
import retrofit2.http.GET

interface Repository {
    @GET("users")
    suspend fun getUsers(): List<User>
}