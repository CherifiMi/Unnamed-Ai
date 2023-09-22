package com.example.unnamedai




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