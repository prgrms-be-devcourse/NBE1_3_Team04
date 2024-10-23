package com.grepp.nbe1_3_team04.vote.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

internal class VoteItemDateTest {

    @DisplayName("투표 상세 항목 생성")
    @Test
    fun createVoteItem() {
        //given
        val endAt = LocalDateTime.now().plusDays(1)
        val vote = Vote.create(1L, 1L, "투표 제목", endAt)

        val voteItem = LocalDateTime.now().plusDays(2)
        //when
        val voteItemDate = VoteItemDate.create(vote, voteItem)

        //then
        Assertions.assertThat(voteItemDate).isNotNull()
            .extracting("time")
            .isEqualTo(voteItem)
    }

    @DisplayName("투표 상세 항목 생성 시 투표 종료 시간보다 이른 시간을 선택할 수 없다.")
    @Test
    fun createVoteItemWhenVoteItemIsBeforeEndAtThrowException() {
        //given
        val endAt = LocalDateTime.now().plusDays(2)
        val vote = Vote.create(1L, 1L, "투표 제목", endAt)
        //when
        //then
        Assertions.assertThatIllegalArgumentException().isThrownBy { VoteItemDate.create(vote, endAt.minusDays(1)) }
            .withMessage("투표 종료 시간보다 이른 시간을 선택할 수 없습니다.")
    }
}