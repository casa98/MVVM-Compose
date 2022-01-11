package com.casa98.usersapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.casa98.usersapi.ui.theme.UsersAPITheme
import com.casa98.usersapi.ui.user_list.TodoListScreen
import com.casa98.usersapi.ui.user_list.UserListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UsersAPITheme {
                val viewModel: UserListViewModel = hiltViewModel()
                // Greeting(name = "Ohhh, Los Del Sur!!")
                TodoListScreen()
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    UsersAPITheme {
        Greeting("Android")
    }
}