package com.grepp.nbe1_3_team04.chat.api.request

import com.grepp.nbe1_3_team04.chat.service.request.ChatroomServiceRequest
import jakarta.validation.constraints.NotBlank

@JvmRecord
data class ChatroomRequest(
    val name: @NotBlank(message = "채팅방 이름은 필수입니다.") String?
) {
    fun toServiceRequest(): ChatroomServiceRequest {
        return ChatroomServiceRequest(name!!)
    }
}
