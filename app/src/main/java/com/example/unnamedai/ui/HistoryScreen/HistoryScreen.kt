package com.example.unnamedai.ui.HistoryScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unnamedai.R
import com.example.unnamedai.showHistoryScreen
import com.example.unnamedai.theme.Black
import com.example.unnamedai.theme.Red
import com.example.unnamedai.theme.White
import com.example.unnamedai.theme.abel

@Composable
fun HistoryScreen() {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            Modifier
                .height(72.dp)
                .padding(start = 20.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {

            IconButton(
                modifier = Modifier
                    .clip(RoundedCornerShape(100)),
                onClick = {
                    showHistoryScreen.value = false
                }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.arrow_square_left),
                    contentDescription = null
                )
            }
            Text(
                text = "Menu",
                fontFamily = abel,
                fontSize = 28.sp,
                color = White,
            )

        }

        Box(
            modifier = Modifier
                .background(White, RoundedCornerShape(20))
                .fillMaxWidth()
                .height(56.dp),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = "Start New Chat",
                fontFamily = abel,
                fontSize = 20.sp,
                lineHeight = 24.sp,
                color = Black,
            )
        }

        Text(
            modifier = Modifier.padding(24.dp),
            text = "Chat History",
            fontFamily = abel,
            fontSize = 25.sp,
            lineHeight = 22.sp,
            color = White,
        )

    }
}