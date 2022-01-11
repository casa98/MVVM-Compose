package com.casa98.usersapi.data

import com.casa98.usersapi.data.models.User
import com.casa98.usersapi.data.remote.UserApi
import kotlinx.coroutines.flow.Flow

class UserRepositoryImpl(
    private val api: UserApi
): UserRepository {

    override suspend fun getUsers(): List<User> {
        return api.getUsers()
    }
}