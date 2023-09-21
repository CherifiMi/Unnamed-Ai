package com.example.unnamedai.domain.repository

import com.example.unnamedai.domain.model.Conversation

interface DatabaseRepository{
    fun saveConversation(conv: Conversation)
    fun getAllConversation(): List<Conversation>
}