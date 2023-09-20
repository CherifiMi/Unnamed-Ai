package com.example.unnamedai.ui.ChatScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MonotonicFrameClock
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unnamedai.R
import com.example.unnamedai.theme.Black
import com.example.unnamedai.theme.DarkLogo
import com.example.unnamedai.theme.Grey
import com.example.unnamedai.theme.Input
import com.example.unnamedai.theme.Red
import com.example.unnamedai.theme.White
import com.example.unnamedai.theme.Yellow
import com.example.unnamedai.theme.abel
import com.example.unnamedai.ui.StartScreen.Components.UnnamedTextField

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ChatScreen(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(72.dp)
                    .padding(horizontal = 20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = R.drawable.dark_ic_unnamed),
                    contentDescription = null
                )
                Image(painter = painterResource(id = R.drawable.menu), contentDescription = null)
            }
        },
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(72.dp)
                    .background(Input, RoundedCornerShape(topEndPercent = 20, topStartPercent = 20))
                    .clip(
                        RoundedCornerShape(topEndPercent = 20, topStartPercent = 20)
                    ),
                contentAlignment = Alignment.CenterStart
            ) {
                TextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier
                        .border(BorderStroke(1.dp, Color.Transparent))
                        .fillMaxWidth(),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    placeholder = {
                        Text(
                            modifier = Modifier.alpha(.5f),
                            text = "Write anything...",
                            fontFamily = abel,
                            lineHeight = 22.sp,
                            fontSize = 18.sp,
                            color = White,
                        )
                    }
                )
            }
        },
        backgroundColor = Color.Black
    ) {
        Column(
            modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState(), reverseScrolling = true)
        ) {
            Spacer(modifier = Modifier.height(72.dp))


            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(40.dp),
                text = "Lets get this conversation between Super Mario and Bowser started!",
                textAlign = TextAlign.Center,
                fontFamily = abel,
                lineHeight = 28.sp,
                fontSize = 22.sp,
                color = White,
            )



            Spacer(modifier = Modifier.height(72.dp))
        }
    }
}