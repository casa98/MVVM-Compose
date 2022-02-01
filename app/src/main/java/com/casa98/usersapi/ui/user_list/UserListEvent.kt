package com.casa98.usersapi.ui.user_list

import com.casa98.usersapi.data.models.User

sealed class UserListEvent {
    // Use object if not params required
    data class OnUserClick(val user: User): UserListEvent()
    // object OnAddUserClick: UserListEvent()
}