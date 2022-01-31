package com.casa98.usersapi.ui.user_list

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.casa98.usersapi.data.UserRepository
import com.casa98.usersapi.util.UIEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    repository: UserRepository
): ViewModel() {

    val users = repository.getUsers()

    private val _uiEvent = Channel<UIEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()      // We can subscribe to it from UI

    // private val _state = mutableStateOf(UserListState())
    // val state: State<UserListState> = _state;

    init {
        viewModelScope.launch {
            users.map {  }
        }
    }
}
