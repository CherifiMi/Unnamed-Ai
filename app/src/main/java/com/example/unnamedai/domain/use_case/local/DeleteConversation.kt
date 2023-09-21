package com.example.unnamedai.domain.use_case.local

import com.example.unnamedai.domain.repository.DatabaseRepository

class DeleteConversation (
    private val databaseRepository: DatabaseRepository
) {
    operator fun invoke(id: Int){
        return databaseRepository.deleteConversation(id)
    }
}