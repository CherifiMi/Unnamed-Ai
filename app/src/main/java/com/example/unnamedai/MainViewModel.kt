package com.example.unnamedai

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf


//main
val showChatScreen = mutableStateOf(false)
val showHistoryScreen = mutableStateOf(false)

//start
var wlcVisibility = mutableStateOf(false)
var setterVisibility = mutableStateOf(false)


//text fields
var youTF = mutableStateOf("")
var youWhoTF = mutableStateOf("")
var themTF = mutableStateOf("")
var themWhoTF = mutableStateOf("")

var chatTF = mutableStateOf("")


//mock data
val currentConvo = mutableStateListOf<Message>()


var history = listOf(
    Convo(
        you = "SuperMario",
        them = "Bowser",
        date = "Today",
        talk = listOf()
    ),
    Convo(
        you = "UsersName",
        them = "AiName",
        date = "02 Feb, 2023",
        talk = listOf()
    ),
    Convo(
        you = "UsersName2",
        them = "AiName2",
        date = "10 Feb, 2023",
        talk = listOf()
    ),
)


data class Convo(
    val you: String,
    val them: String,
    val date: String,
    val talk: List<Message>,
)

data class Message(
    val from: String,
    val content: String
)