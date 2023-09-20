package com.example.unnamedai.ui.StartScreen.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unnamedai.*
import com.example.unnamedai.showChatScreen
import com.example.unnamedai.theme.Black
import com.example.unnamedai.theme.Border
import com.example.unnamedai.theme.Grey
import com.example.unnamedai.theme.Input
import com.example.unnamedai.theme.abel


@Composable
fun ChatSetter(modifier: Modifier = Modifier) {

    Column(
        modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState(), reverseScrolling = true)
            .background(
                Color.White,
            )
    ) {

        Text(
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 40.dp, bottom = 20.dp)
                .fillMaxWidth(),
            text = "Lets setup a chat!",
            letterSpacing = 0.36.sp,
            fontFamily = abel,
            fontSize = 28.sp,
            color = Black,
        )

        Text(
            modifier = Modifier
                .padding(start = 20.dp, bottom = 20.dp)
                .fillMaxWidth(),
            text = "We need a few details to get started.\n(you can change this at any time)",
            textAlign = TextAlign.Start,
            fontFamily = abel,
            lineHeight = 20.sp,
            fontSize = 17.sp,
            color = Black,
        )

        UnnamedTextField(placeholder = "Enter your name/alias", value = youTF)
        UnnamedTextField(placeholder = "Enter some information about yourself.", value = youWhoTF)

        Spacer(modifier = Modifier.height(24.dp))

        UnnamedTextField(placeholder = "Enter the name of  “Your Ai”.", value = themTF)
        UnnamedTextField(placeholder = "Enter some information about “Your Ai”", value = themWhoTF)

        UnnamedButton(text = "Start Chat") {
            showChatScreen.value = true
        }


    }
}

@Composable
fun UnnamedTextField(
    modifier: Modifier = Modifier,
    placeholder: String,
    value: MutableState<String>
) {
    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 20.dp),
        value = value.value,
        onValueChange = { value.value = it },
        placeholder = {
            Text(
                text = placeholder,
                fontFamily = abel,
                lineHeight = 22.sp,
                fontSize = 18.sp,
                color = Grey,
            )
        },
        shape = RoundedCornerShape(20),
        textStyle = TextStyle(
            color = Input, fontFamily = abel,
            lineHeight = 22.sp,
            fontSize = 18.sp
        ),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Grey,
            unfocusedBorderColor = Border
        ),

        )
}