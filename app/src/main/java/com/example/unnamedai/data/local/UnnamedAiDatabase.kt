package com.example.unnamedai.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.unnamedai.domain.model.Conversation
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


@Database(
    entities = [Conversation::class],
    version = 1
)

@TypeConverters(Converters::class)
abstract class UnnamedAiDatabase: RoomDatabase() {
    abstract val unnamedAiDao: UnnamedAiDao

    companion object {
        const val Database_Name = "database"
    }
}

class Converters {
    /*@TypeConverter
    fun fromTimestamp(timestamp: List<Timestamp?>): String {
        return Gson().toJson(timestamp)
    }

    @TypeConverter
    fun toTimestamp(json: String): List<Timestamp?> {
        return Gson().fromJson<List<Timestamp?>>(json)
    }*/
}

inline fun <reified T> Gson.fromJson(json: String) =
    fromJson<T>(json, object : TypeToken<T>() {}.type)