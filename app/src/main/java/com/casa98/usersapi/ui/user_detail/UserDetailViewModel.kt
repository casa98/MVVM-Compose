package com.casa98.usersapi.ui.user_detail

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.casa98.usersapi.data.UserRepository
import com.casa98.usersapi.data.models.User
import com.casa98.usersapi.util.UIEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject

@HiltViewModel
class UserDetailViewModel @Inject constructor(
    // private val repository: UserRepository,
    savedStateHandle: SavedStateHandle  // Also magically works thanks to Hilt
): ViewModel() {

    private val _uiEvent = Channel<UIEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    // Ugly but yeah, we'll learn more later one
    val name: String = savedStateHandle.get<String>("name") ?: ""
    val email: String = savedStateHandle.get<String>("email") ?: ""

}