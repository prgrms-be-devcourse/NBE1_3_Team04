package com.grepp.nbe1_3_team04.vote.domain

import jakarta.persistence.Entity
import java.time.LocalDateTime

@Entity
class VoteItemDate private constructor(
    vote: Vote,
    time: LocalDateTime
) : VoteItem(vote) {

    val time: LocalDateTime

    init {
        vote.endAt?.let { validateTime(time, it) }
        this.time = time
    }

    private fun validateTime(time: LocalDateTime, endAt: LocalDateTime) {
        require(!time.isBefore(endAt)) { "투표 종료 시간보다 이른 시간을 선택할 수 없습니다." }
    }

    companion object {
        fun create(vote: Vote, time: LocalDateTime): VoteItemDate {
            return VoteItemDate(vote, time)
        }
    }

}
