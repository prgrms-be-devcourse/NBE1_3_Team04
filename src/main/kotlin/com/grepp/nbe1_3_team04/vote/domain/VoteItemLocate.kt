package com.grepp.nbe1_3_team04.vote.domain

import jakarta.persistence.Entity

@Entity
class VoteItemLocate private constructor(
    vote: Vote,
    val courtId: Long
) : VoteItem(vote) {

    companion object {
        fun create(vote: Vote, courtId: Long): VoteItemLocate {
            return VoteItemLocate(vote, courtId)
        }
    }

}
