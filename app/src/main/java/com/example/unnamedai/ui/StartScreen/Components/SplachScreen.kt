package com.example.unnamedai.ui.StartScreen.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.unnamedai.R

@Composable
fun SplachScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier
        .fillMaxSize()
        .background(Color.Black), contentAlignment = Alignment.Center
    ){
        Image(painter = painterResource(id = R.drawable.ic_unamed_ui), contentDescription = null)
    }
}