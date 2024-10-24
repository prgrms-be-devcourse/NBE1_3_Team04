package com.grepp.nbe1_3_team04.chat.service.response

import com.grepp.nbe1_3_team04.chat.domain.Chat
import com.grepp.nbe1_3_team04.chat.domain.ChatType
import java.time.LocalDateTime

@JvmRecord
data class ChatResponse(
    val chatId: Long?,
    val createdAt: LocalDateTime?,
    val updatedAt: LocalDateTime?,
    val chatroomResponse: ChatroomResponse,
    val memberInfo: ChatMemberInfo,
    val chatType: ChatType,
    val text: String
) {
    constructor(chat: Chat) : this(
        chat.chatId,
        chat.createdAt,
        chat.updatedAt,
        ChatroomResponse(chat.chatRoom),
        ChatMemberInfo(chat.member),
        chat.chatType,
        chat.text
    )
}
