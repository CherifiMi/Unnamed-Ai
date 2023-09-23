package com.example.unnamedai.ui.ChatScreen

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkOut
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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.unnamedai.MainEvents
import com.example.unnamedai.MainViewModel
import com.example.unnamedai.R
import com.example.unnamedai.domain.model.From
import com.example.unnamedai.domain.model.Msg
import com.example.unnamedai.ui.ChatScreen.components.LoadingBall
import com.example.unnamedai.util.theme.Black
import com.example.unnamedai.util.theme.Blue
import com.example.unnamedai.util.theme.Input
import com.example.unnamedai.util.theme.White
import com.example.unnamedai.util.theme.abel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ChatScreen(modifier: Modifier = Modifier, viewmodel: MainViewModel = hiltViewModel()) {
    val state = viewmodel.state.value

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
                IconButton(
                    modifier = Modifier
                        .clip(RoundedCornerShape(100)),
                    onClick = {
                        viewmodel.onEvent(MainEvents.ClickGoToHistory)
                    }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.menu),
                        contentDescription = null
                    )
                }
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
                    value = state.chatTF,
                    onValueChange = { viewmodel.onEvent(MainEvents.ChatTfChanged(it)) },
                    modifier = Modifier
                        .border(BorderStroke(1.dp, Color.Transparent))
                        .fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(onDone = {
                        if (!state.loadingChatRespond){
                            viewmodel.onEvent(MainEvents.PressDoneOnKeyboard)
                        }
                    }),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        cursorColor = White
                    ),
                    textStyle = TextStyle(
                        fontFamily = abel,
                        lineHeight = 22.sp,
                        fontSize = 18.sp,
                        color = White,
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
        LazyColumn(
            reverseLayout = true,
            modifier = modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            item {
                Spacer(modifier = Modifier.height(72.dp))
            }

            item {
                if (state.loadingChatRespond){
                    Box(modifier = Modifier
                        .size(80.dp)
                        .padding(8.dp),
                        contentAlignment = Alignment.Center
                    ){
                        LoadingBall()
                    }
                }
            }


            items(state.currentConversation!!.talk.reversed()) {
                if (it.from == From.You) {
                    YouItem(it, state.youTF)
                } else {
                    Spacer(modifier = Modifier.height(40.dp))
                    ThemItem(it, state.themTF)
                }
            }

            item {
                AnimatedVisibility(
                    visible = state.currentConversation.talk.size == 0,
                    enter = fadeIn(),
                    exit = fadeOut() + shrinkOut()
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(40.dp),
                        text = "Lets get this conversation between ${state.youTF} and ${state.themTF} started!",
                        textAlign = TextAlign.Center,
                        fontFamily = abel,
                        lineHeight = 28.sp,
                        fontSize = 22.sp,
                        color = White,
                    )
                }
            }

            item {
                Spacer(modifier = Modifier.height(72.dp))
            }
        }
    }
}

@Composable
fun YouItem(item: Msg, name: String) {

    var animation by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        animation = true
    }

    AnimatedVisibility(visible = animation, enter = fadeIn()) {
        Column(
            Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                text = item.content,
                textAlign = TextAlign.Start,
                fontFamily = abel,
                lineHeight = 28.sp,
                fontSize = 22.sp,
                color = White,
            )
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(
                    modifier = Modifier
                        .padding(start = 24.dp)
                        .alpha(.5f),
                    text = "You (${name})",
                    fontFamily = abel,
                    fontSize = 16.sp,
                    lineHeight = 21.sp,
                    color = White,
                )
                Image(
                    modifier = Modifier
                        .padding(end = 24.dp)
                        .alpha(.5f),
                    painter = painterResource(id = R.drawable.more),
                    contentDescription = null
                )
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
        }
    }
}


@Composable
fun ThemItem(item: Msg, name: String) {
    var animation by remember {
        mutableStateOf(false)
    }


    LaunchedEffect(Unit) {
        animation = true
    }

    AnimatedVisibility(
        visible = animation, enter =  fadeIn()
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(20.dp)
                .background(White, RoundedCornerShape(10.dp))

        ) {
            Box(
                Modifier
                    .offset(y = -20.dp)
                    .padding(horizontal = 20.dp)
                    .size(40.dp)
                    .background(Blue, RoundedCornerShape(100))
                    .clip(RoundedCornerShape(100)),
                contentAlignment = Alignment.Center
            ){
                Image(painter = painterResource(id = R.drawable.white_ball), contentDescription = null)
            }

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .padding(bottom = 15.dp),
                text = item.content,
                textAlign = TextAlign.Start,
                fontFamily = abel,
                lineHeight = 28.sp,
                fontSize = 22.sp,
                color = Black,
            )

            Row(
                Modifier
                    .height(34.dp)
                    .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Spacer(modifier = Modifier.size(8.dp))
                Icon(
                    modifier = Modifier
                        .padding(end = 24.dp)
                        .alpha(.5f),
                    tint = Black,
                    painter = painterResource(id = R.drawable.more),
                    contentDescription = null
                )
            }

            Text(
                modifier = Modifier
                    .padding(start = 24.dp)
                    .alpha(.5f),
                text = "Them (${name})",
                fontFamily = abel,
                fontSize = 16.sp,
                lineHeight = 21.sp,
                color = Black,
            )

        }
    }
}