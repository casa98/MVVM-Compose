package com.casa98.usersapi.ui.user_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.casa98.usersapi.data.UserRepository
import com.casa98.usersapi.util.Routes
import com.casa98.usersapi.util.UIEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    repository: UserRepository
): ViewModel() {

    val users = repository.getUsers()

    private val _uiEvent = Channel<UIEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onEvent(event: UserListEvent){
        when (event) {
            is UserListEvent.OnUserClick -> sendUIEvent(UIEvent.Navigate(
                Routes.USER_DETAIL+ "?name=${event.user.name}&email=${event.user.email}"
            ))
        }
    }

    private fun sendUIEvent(event: UIEvent) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }
}
