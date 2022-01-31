package com.casa98.usersapi.data

import com.casa98.usersapi.data.models.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    fun getUsers(): Flow<List<User>>
}