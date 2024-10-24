package com.grepp.nbe1_3_team04.chat.service.response

import com.grepp.nbe1_3_team04.chat.domain.Chatroom


@JvmRecord
data class ChatroomResponse(
    val chatroomId: Long?,
    val name: String
) {
    constructor(chatroom: Chatroom) : this(
        chatroom.chatroomId,
        chatroom.name
    )
}
