package com.casa98.usersapi.ui.user_list

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.casa98.usersapi.data.models.User

@Composable
fun UserItem(
    user: User,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(horizontal = 16.dp),
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = user.name,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        // Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = user.email,
            fontSize = 16.sp,
        )
        Text(
            text = user.phone,
            fontSize = 16.sp,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Divider()
    }
}
