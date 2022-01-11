package com.casa98.usersapi.ui.user_list

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun TodoListScreen(
    viewModel: UserListViewModel = hiltViewModel()
) {
    Text("Ohh, Los Del Sur!!")
}