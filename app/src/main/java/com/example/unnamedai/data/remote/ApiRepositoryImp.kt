package com.example.unnamedai.data.remote

import com.example.unnamedai.domain.repository.ApiRepository

class ApiRepositoryImp(private val caravanApi: UnnamedAiApi): ApiRepository {
    override suspend fun askChatGBT(question: String): String {


        //caravanApi.chatgbt()



        return "$question  $question  $question  $question  $question"
    }
}