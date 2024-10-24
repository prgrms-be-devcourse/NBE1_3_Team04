package com.grepp.nbe1_3_team04.chat.domain

import com.grepp.nbe1_3_team04.global.domain.BaseEntity
import com.grepp.nbe1_3_team04.member.domain.Member
import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import org.hibernate.annotations.SQLDelete

@Entity
@SQLDelete(sql = "UPDATE chat_member SET is_deleted = 'true' WHERE chat_member_id = ?")
class ChatMember private constructor(
    member: Member,
    chatroom: Chatroom
) : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val chatMemberId: Long? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    val member: Member = member

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chatroom_id", nullable = false)
    val chatroom: Chatroom = chatroom

    companion object {
        fun create(member: Member, chatRoom: Chatroom): ChatMember {
            return ChatMember(member, chatRoom)
        }
    }
}
