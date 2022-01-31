package com.casa98.usersapi.ui.user_list

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun TodoListScreen(
    viewModel: UserListViewModel = hiltViewModel(),
) {
    val users = viewModel.users.collectAsState(initial = emptyList())
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
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
                            }
                    )
                }
            }
    }
}