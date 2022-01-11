package com.casa98.usersapi.ui.user_list

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.casa98.usersapi.data.UserRepository
import com.casa98.usersapi.data.models.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    private val repository: UserRepository
): ViewModel() {

    var users: List<User> = emptyList()

    init {
        Log.i("DONE", "Llegamos pai")
        viewModelScope.launch {
            users = repository.getUsers()
        }

    }
}
