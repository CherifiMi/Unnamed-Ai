package com.example.unnamedai.ui.StartScreen.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unnamedai.R
import com.example.unnamedai.theme.*
import com.example.unnamedai.ui.setterVisibility

@Composable
fun WelcomePopUp(modifier: Modifier = Modifier) {
    Column(
        modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .background(White, RoundedCornerShape(topEndPercent = 10, topStartPercent = 10)),
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 40.dp, bottom = 20.dp)
                .fillMaxWidth(),
            text = "Welcome to " + stringResource(id = R.string.app_name),
            fontFamily = abel,
            fontSize = 28.sp,
            color = Black,
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)
                .padding(horizontal = 30.dp),
            textAlign = TextAlign.Center,
            text =
            buildAnnotatedString {
                withStyle(style = SpanStyle(color = Grey)) {
                    append("Read our ")
                }
                withStyle(style = SpanStyle(color = Blue)) {
                    append("Privacy Policy")
                }
                withStyle(style = SpanStyle(color = Grey)) {
                    append(". Tap ”Get Started” to accept the ")
                }
                withStyle(style = SpanStyle(color = Blue)) {
                    append("Terms of Service.")
                }
            },
            lineHeight = 21.sp,
            fontFamily = abel,
            fontSize = 16.sp,
            color = Black,
        )

        UnnamedButton(text = "Get Started") {
            setterVisibility.value = true
        }

        Spacer(modifier = Modifier.size(34.dp))

    }
}
