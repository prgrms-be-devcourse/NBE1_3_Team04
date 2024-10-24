package com.grepp.nbe1_3_team04.chat.service.request

@JvmRecord
data class ChatServiceRequest(
    val chatroomId: Long,
    val message: String
)
