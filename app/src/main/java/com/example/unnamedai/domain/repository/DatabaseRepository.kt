package com.example.unnamedai.domain.repository

import com.example.unnamedai.domain.model.Conversation

interface DatabaseRepository{
    suspend fun saveConversation(conv: Conversation)
    fun deleteConversation(id: Int)
    fun getAllConversation(): List<Conversation>
}