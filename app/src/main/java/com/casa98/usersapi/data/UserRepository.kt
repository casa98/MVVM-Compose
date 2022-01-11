package com.casa98.usersapi.data

import com.casa98.usersapi.data.models.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    suspend fun getUsers(): List<User>
}