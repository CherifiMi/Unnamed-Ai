package com.example.unnamedai.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectVerticalDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.example.unnamedai.showChatScreen
import com.example.unnamedai.ui.StartScreen.Components.ChatSetter
import com.example.unnamedai.ui.StartScreen.Components.SplachScreen
import com.example.unnamedai.ui.StartScreen.Components.WelcomePopUp


var wlcVisibility = mutableStateOf(false)
var setterVisibility = mutableStateOf(false)


@Composable
fun StartScreen(modifier: Modifier = Modifier) {


    Box(modifier = Modifier.fillMaxSize()) {

        Column(modifier.fillMaxSize()) {

            SplachScreen(
                Modifier
                    .weight(.7f)
                    .pointerInput(Unit) {
                        detectVerticalDragGestures(onDragEnd = { wlcVisibility.value = true}) { change, dragAmount -> }
                    })

            AnimatedVisibility(
                modifier = Modifier.clip(
                    RoundedCornerShape(
                        topStartPercent = 10,
                        topEndPercent = 10
                    )
                ),
                visible = wlcVisibility.value && !setterVisibility.value,
            ) {

                WelcomePopUp(
                    Modifier
                        .weight(.3f))

            }
        }

        val density = LocalDensity.current


        AnimatedVisibility(
            enter = slideInVertically {
                with(density) { 300.dp.roundToPx() }
            },
            exit = slideOutVertically() + shrinkVertically() + fadeOut(),
            visible = setterVisibility.value
        ) {
            ChatSetter()
        }

    }
}