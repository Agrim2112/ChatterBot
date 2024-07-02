package com.example.chatterbot.data

import android.graphics.Bitmap
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.content
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object ChatData {
    val apiKey:String="AIzaSyAoWwqcHikMxdkqnxGGJnCr_HDMglcT-p4"

    suspend fun getResponse(prompt:String):Chat{
        val generativeModel = GenerativeModel(
            modelName = "gemini-pro",
            apiKey = apiKey
        )

        try {
            val response = withContext(Dispatchers.IO){
                generativeModel.generateContent(prompt)
            }

            return Chat(
                response.text?:"Error occurred",
                null,
                false)
        }
        catch (e:Exception){
            return Chat(
                e.message?:"Error occurred",
                null,
                false)
        }
    }

    suspend fun getResponse(prompt:String,bitmap: Bitmap):Chat{
        val generativeModel = GenerativeModel(
            modelName = "gemini-pro-vision",
            apiKey = apiKey
        )

        val input = content {
            image(bitmap)
            text(prompt)
        }
        try {
            val response = withContext(Dispatchers.IO){
                generativeModel.generateContent(input)
            }

            return Chat(
                response.text?:"Error occurred",
                null,
                false)
        }
        catch (e:Exception){
            return Chat(
                e.message?:"Error occurred",
                null,
                false)
        }
    }
}