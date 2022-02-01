package com.casa98.usersapi.ui.user_list

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewModelScope
import com.casa98.usersapi.util.UIEvent
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@Composable
fun UserListScreen(
    onNavigate: (UIEvent.Navigate) -> Unit,
    viewModel: UserListViewModel = hiltViewModel(),
) {
    val users = viewModel.users.collectAsState(initial = emptyList())
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UIEvent.Navigate -> onNavigate(event)
                UIEvent.PopBackStack -> {}
                is UIEvent.ShowSnackBar -> {}
            }
        }
    }

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Users")
                },
                navigationIcon = {
                    IconButton(onClick = {
                        scope.launch { scaffoldState.drawerState.open() }
                    }) {
                        Icon(Icons.Filled.Menu, "Drawer button")
                    }
                }
            )
        },
        drawerContent = {
            Box(modifier = Modifier.fillMaxSize()) {
                Text(
                    text = "Nothing here :p",
                    fontSize = 18.sp,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    ) {
        if(users.value.isEmpty())
            Box (
                modifier = Modifier.fillMaxSize()
            ){
                Text(
                    "Loading...",
                    fontSize = 20.sp,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        else
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                items(users.value) { user ->
                    UserItem(
                        user = user,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                Log.i(user.name, "CLICK")
                                viewModel.onEvent(UserListEvent.OnUserClick(user))
                            }
                    )
                }
            }
    }
}