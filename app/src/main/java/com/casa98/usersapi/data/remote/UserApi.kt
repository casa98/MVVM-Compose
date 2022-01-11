package com.casa98.usersapi.data.remote

import com.casa98.usersapi.data.models.User
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApi {

    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com"
    }

    @GET("/users")
    suspend fun getUsers(): List<User>

}