package com.example.unnamedai.data.remote

import com.example.unnamedai.domain.model.ChatRequest
import com.example.unnamedai.domain.model.Message
import com.example.unnamedai.domain.repository.ApiRepository
import com.example.unnamedai.util.OPEN_AI_API_KEY

class ApiRepositoryImp(private val caravanApi: UnnamedAiApi) : ApiRepository {
    override suspend fun askChatGBT(question: String): String {

        val chatRequest = ChatRequest(
            model = "gpt-4"/*"gpt-3.5-turbo"*/,
            messages = listOf(
                Message(role = "user", content = question)
            )
        )

        val response = caravanApi.askChat2(
            authorization = "Bearer $OPEN_AI_API_KEY",
            request = chatRequest
        )

        return response.body()?.choices?.last()?.message?.content ?: "sorry no data"
    }
}