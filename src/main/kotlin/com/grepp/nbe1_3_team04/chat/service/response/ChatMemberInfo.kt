package com.grepp.nbe1_3_team04.chat.service.response

import com.grepp.nbe1_3_team04.member.domain.Member
import com.grepp.nbe1_3_team04.member.domain.MemberRole

@JvmRecord
data class ChatMemberInfo(
    val memberId: Long?,
    val email: String,
    val name: String,
    val memberRole: MemberRole
) {
    constructor(member: Member) : this(
        member.memberId,
        member.email,
        member.name,
        member.memberRole
    )
}
