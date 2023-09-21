package com.example.unnamedai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.unnamedai.util.theme.Blue
import com.example.unnamedai.util.theme.UnnamedAiTheme
import com.example.unnamedai.ui.ChatScreen.ChatScreen
import com.example.unnamedai.ui.HistoryScreen.HistoryScreen
import com.example.unnamedai.ui.StartScreen


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnnamedAiTheme {
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

        AnimatedVisibility(
            visible = showHistoryScreen.value,
            enter = slideInHorizontally(
                initialOffsetX = { 300 },
                animationSpec = tween(durationMillis = 300)
            )+ fadeIn(),
            exit = slideOutHorizontally(
                targetOffsetX = { 300 },
                animationSpec = tween(durationMillis = 300)
            )+ fadeOut()
        ) {
            HistoryScreen()
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