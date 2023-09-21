package com.example.unnamedai.data.remote

import com.example.unnamedai.domain.repository.ApiRepository

class ApiRepositoryImp(): ApiRepository {
    override fun askChatGBT(question: String): String {
        return "chat gpt respond"
    }
}