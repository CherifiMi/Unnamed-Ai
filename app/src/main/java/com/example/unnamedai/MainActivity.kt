package com.example.unnamedai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.unnamedai.theme.UnnamedAiTheme
import com.example.unnamedai.ui.ChatScreen.ChatScreen
import com.example.unnamedai.ui.StartScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnnamedAiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    App()
                }
            }
        }
    }
}

val showChatScreen = mutableStateOf(false)

@Composable
fun App() {
    Box(modifier = Modifier.fillMaxSize()) {

        AnimatedVisibility(
            exit = fadeOut(),
            visible = !showChatScreen.value
        ) {
            StartScreen()
        }

        AnimatedVisibility(
            enter = fadeIn(),
            exit = fadeOut(),
            visible = showChatScreen.value
        ) {
            ChatScreen()
        }

    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    UnnamedAiTheme {
        App()
    }
}