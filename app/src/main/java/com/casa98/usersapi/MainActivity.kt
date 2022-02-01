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
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.casa98.usersapi.ui.theme.UsersAPITheme
import com.casa98.usersapi.ui.user_detail.UserDetailScreen
import com.casa98.usersapi.ui.user_list.UserListScreen
import com.casa98.usersapi.util.Routes
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UsersAPITheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Routes.USER_LIST
                ) {
                    composable(Routes.USER_LIST) {
                        UserListScreen(onNavigate = {
                            navController.navigate(it.route)
                        })
                    }

                    composable(
                        Routes.USER_DETAIL + "?name={name}&email={email}",
                    ) {
                        UserDetailScreen(onPopBackStack = {
                            navController.popBackStack()
                        })
                    }
                }
            }
        }
    }
}
