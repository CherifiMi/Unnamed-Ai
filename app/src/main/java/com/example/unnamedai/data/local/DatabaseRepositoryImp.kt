package com.example.unnamedai.data.local

import com.example.unnamedai.domain.model.Conversation
import com.example.unnamedai.domain.repository.DatabaseRepository

class DatabaseRepositoryImp(private val dao: UnnamedAiDao):DatabaseRepository {

    override fun saveConversation(conv: Conversation) {
        dao.saveConversation(conv)
    }

    override fun deleteConversation(id: Int) {
        dao.deleteConversation(id)
    }

    override fun getAllConversation(): List<Conversation> {
        return dao.getAllConversation() ?: emptyList()
    }
}