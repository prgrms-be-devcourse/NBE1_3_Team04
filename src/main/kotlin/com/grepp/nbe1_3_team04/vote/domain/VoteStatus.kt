package com.grepp.nbe1_3_team04.vote.domain


enum class VoteStatus(private val text: String) {
    OPENED("진행 중"),
    CLOSED("종료")
    ;
}
