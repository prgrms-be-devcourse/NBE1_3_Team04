package com.grepp.nbe1_3_team04.chat.service.request

@JvmRecord
data class ChatMemberServiceRequest(
    val chatroomId: Long,
    val memberId: Long
)
