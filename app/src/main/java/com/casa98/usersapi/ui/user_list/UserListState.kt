package com.casa98.usersapi.ui.user_list

import com.casa98.usersapi.data.models.User

data class UserListState(
    val items: List<User> = emptyList(),
    val isLoading: Boolean = false
)