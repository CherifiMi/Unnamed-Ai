package com.example.unnamedai.ui

import android.widget.GridLayout
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.example.unnamedai.showChatScreen
import com.example.unnamedai.ui.StartScreen.Components.ChatSetter
import com.example.unnamedai.ui.StartScreen.Components.SplachScreen
import com.example.unnamedai.ui.StartScreen.Components.WlcomePopUp



var wlcVisibility  = mutableStateOf(false)
var setterVisibility  = mutableStateOf(false)


@Composable
fun StartScreen(modifier: Modifier = Modifier) {



    Box(modifier = Modifier.fillMaxSize()){

        Column(modifier.fillMaxSize()) {

            SplachScreen(Modifier.weight(.7f).clickable { wlcVisibility.value = true })

            AnimatedVisibility(visible = wlcVisibility.value && !setterVisibility.value) {

                WlcomePopUp(Modifier.weight(.3f).clickable { setterVisibility.value = true })

            }
        }

        val density = LocalDensity.current


        AnimatedVisibility(
            enter = slideInVertically {
                with(density) { 300.dp.roundToPx() }
            },
            exit = slideOutVertically() + shrinkVertically() + fadeOut(),
            visible = setterVisibility.value) {
            ChatSetter(Modifier.clickable { showChatScreen.value = true })
        }

    }
}