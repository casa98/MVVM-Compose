package com.casa98.usersapi.data

import com.casa98.usersapi.data.models.User
import com.casa98.usersapi.data.remote.UserApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UserRepositoryImpl(
    private val api: UserApi
): UserRepository {

    override fun getUsers(): Flow<List<User>> = flow{
        val users = api.getUsers()
        emit(users)
    }
}