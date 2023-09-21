package com.example.unnamedai.domain.use_case.remote

import com.example.unnamedai.domain.repository.ApiRepository

class AskChatGBT(
    private val apiRepository: ApiRepository
) {

    suspend operator fun invoke(q: String): String{
        return apiRepository.askChatGBT(q)
    }

}