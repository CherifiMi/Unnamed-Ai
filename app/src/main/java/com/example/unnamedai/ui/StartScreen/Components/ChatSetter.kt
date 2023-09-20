package com.example.unnamedai.ui.StartScreen.Components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unnamedai.R
import com.example.unnamedai.showChatScreen
import com.example.unnamedai.theme.Black
import com.example.unnamedai.theme.Blue
import com.example.unnamedai.theme.Border
import com.example.unnamedai.theme.Green
import com.example.unnamedai.theme.Grey
import com.example.unnamedai.theme.Red
import com.example.unnamedai.theme.abel
import kotlinx.coroutines.delay


@Composable
fun ChatSetter(modifier: Modifier = Modifier) {

    /*val keyboard = LocalSoftwareKeyboardController.current
    val focusRequester = remember { FocusRequester() }

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
        delay(1000)
        keyboard?.show()
    }*/

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

        UnnamedTextField(/*modifier = Modifier.focusRequester(focusRequester),*/ placeholder = "Enter your name/alias")
        UnnamedTextField(placeholder = "Enter some information about yourself.")

        Spacer(modifier = Modifier.height(24.dp))

        UnnamedTextField(placeholder = "Enter the name of  “Your Ai”.")
        UnnamedTextField(placeholder = "Enter some information about “Your Ai”")

        UnnamedButton(text = "Start Chat") {
            showChatScreen.value = true
        }


    }
}

@Composable
fun UnnamedTextField(modifier: Modifier = Modifier, placeholder: String) {
    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 20.dp),
        value = "",
        onValueChange = { },
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
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Grey,
            unfocusedBorderColor = Border
        )
    )
}