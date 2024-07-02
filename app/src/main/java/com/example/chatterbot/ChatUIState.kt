package com.example.chatterbot

import android.graphics.Bitmap

sealed class ChatUIEvent {
    data class updatePrompt(val newPrompt: String):ChatUIEvent()
    data class sendPrompt(val prompt: String, val bitmap: Bitmap?):ChatUIEvent()
}