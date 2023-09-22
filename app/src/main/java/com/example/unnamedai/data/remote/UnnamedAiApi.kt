package com.example.unnamedai.data.remote

import com.example.unnamedai.domain.model.ChatResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST


data class ChatRequest(
    val model: String,
    val messages: List<Message>
)

data class Message(
    val role: String,
    val content: String
)



interface UnnamedAiApi {

    @Headers("Content-Type: application/json")
    @POST("v1/chat/completions")
    suspend fun askChat(
        @Header("Authorization") authorization: String,
        @Body request: ChatRequest
    ): Call<ChatResponse>

}