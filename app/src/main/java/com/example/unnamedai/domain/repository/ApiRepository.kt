package com.example.unnamedai.domain.repository

interface ApiRepository {
    fun askChatGBT(question: String): String
}