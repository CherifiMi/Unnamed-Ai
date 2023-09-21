package com.example.unnamedai.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.unnamedai.domain.model.Conversation

@Dao
interface UnnamedAiDao {

    @Query("SELECT * FROM conversations")
    fun getAllConversation(): List<Conversation>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveConversation(conv: Conversation)

    @Query("DELETE FROM conversations WHERE id = :id")
    fun deleteConversation(id: Int)

}