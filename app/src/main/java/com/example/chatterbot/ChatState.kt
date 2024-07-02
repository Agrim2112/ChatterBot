package com.example.chatterbot

import android.graphics.Bitmap
import com.example.chatterbot.data.Chat

data class ChatState (
    val chatList:MutableList<Chat> = mutableListOf(),
    val prompt:String="",
    val bitmap: Bitmap?=null
)