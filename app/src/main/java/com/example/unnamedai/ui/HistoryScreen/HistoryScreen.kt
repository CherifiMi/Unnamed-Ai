package com.example.unnamedai.ui.HistoryScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.unnamedai.showHistoryScreen
import com.example.unnamedai.theme.Red

@Composable
fun HistoryScreen() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Red)
        .clickable { showHistoryScreen.value = false }
    ){

    }
}