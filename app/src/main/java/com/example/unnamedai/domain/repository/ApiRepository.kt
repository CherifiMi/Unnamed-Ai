package com.example.unnamedai.domain.repository

interface ApiRepository {
    suspend fun askChatGBT(question: String): String
}