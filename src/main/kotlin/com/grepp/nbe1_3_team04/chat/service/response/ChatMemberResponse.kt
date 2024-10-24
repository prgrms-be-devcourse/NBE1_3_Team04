package com.grepp.nbe1_3_team04.chat.service.response

import com.grepp.nbe1_3_team04.chat.domain.ChatMember


@JvmRecord
data class ChatMemberResponse(
    val chatroomId: Long?,
    val memberId: Long?
) {
    constructor(chatMember: ChatMember) : this(
        chatMember.chatroom.chatroomId,
        chatMember.member.memberId
    )
}
