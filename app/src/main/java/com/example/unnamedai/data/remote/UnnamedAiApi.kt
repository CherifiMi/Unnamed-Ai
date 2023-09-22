package com.example.unnamedai.data.remote

import retrofit2.http.GET

interface UnnamedAiApi {

    @GET("/")
    suspend fun chatgbt(){

    }

}