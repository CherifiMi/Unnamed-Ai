package com.example.unnamedai.domain.model

data class Conversation(
    val name: String,
    val aiName: String,
    val infoAboutYou: String,
    val infoAboutAi: String,
    val date: String,
    val talk: List<Msg>,
)

data class Msg(
    val from: From,
    val content: String
)

enum class From{
    You,
    YourAi
}