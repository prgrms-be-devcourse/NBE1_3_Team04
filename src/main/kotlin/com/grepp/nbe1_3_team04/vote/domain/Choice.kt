package com.grepp.nbe1_3_team04.vote.domain

import jakarta.persistence.*

@Table(
    indexes = [
        Index(name = "idx_choice_member_id", columnList = "memberId"),
        Index(name = "idx_choice_vote_item_id", columnList = "voteItemId")
    ]
)
@Entity
class Choice private constructor(
    val memberId: Long,
    val voteItemId: Long
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val choiceId: Long? = null

    companion object {
        fun create(memberId: Long, voteItemId: Long): Choice {
            return Choice(memberId, voteItemId)
        }
    }

}
