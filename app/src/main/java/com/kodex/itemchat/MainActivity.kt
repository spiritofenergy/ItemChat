package com.kodex.itemchat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.navigation.compose.rememberNavController
import com.kodex.itemchat.MessageData.MessageList
import com.kodex.itemchat.ui.theme.ChatBoxTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatBoxTheme {
                val navController = rememberNavController()
                Navigation(navController)
            }
        }
    }
}
