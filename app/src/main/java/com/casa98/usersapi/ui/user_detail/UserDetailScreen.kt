package com.casa98.usersapi.ui.user_detail

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import org.intellij.lang.annotations.JdkConstants

@Composable
fun UserDetailScreen(
    onPopBackStack: () -> Unit,
    viewModel: UserDetailViewModel = hiltViewModel()
) {
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = { 
                    Text(text = "User Details")
                },
                navigationIcon = {
                    IconButton(onClick = onPopBackStack) {
                        Icon(Icons.Filled.ArrowBack, "Back button")
                    }
                }
            )
        },
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = viewModel.name,
                fontSize = 20.sp,
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = viewModel.email,
                fontSize = 18.sp,
            )
        }
    }
}