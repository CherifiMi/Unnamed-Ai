package com.example.unnamedai.data.remote

import com.example.unnamedai.domain.repository.ApiRepository
import com.example.unnamedai.util.OPEN_AI_API_KEY

class ApiRepositoryImp(private val caravanApi: UnnamedAiApi) : ApiRepository {
    override suspend fun askChatGBT(question: String): String {

        val chatRequest = ChatRequest(
            model = "gpt-3.5-turbo",
            messages = listOf(
                Message(role = "user", content = "What is the OpenAI mission?")
            )
        )

        val response = caravanApi.askChat(
            authorization = "Bearer $OPEN_AI_API_KEY",
            request = chatRequest
        ).execute()

        return if (response.isSuccessful) {
            val chatResponse = response.body()
            chatResponse!!.choices.last().message.content
        } else {
            "not working"
        }
    }
}