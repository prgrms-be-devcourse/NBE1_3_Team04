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
        // TODO: 테스트할 때 voteItemDate의 init에 검증이 제대로 안되고있음 어떤 문제인지 파악해야함 테스트를 통과 못한다는건 실제 로직에 문제있을 가능성이 존재
        //given
        val endAt = LocalDateTime.now().plusDays(2)
        val vote = Vote.create(1L, 1L, "투표 제목", endAt)
        //when
        //then
        Assertions.assertThatIllegalArgumentException().isThrownBy { VoteItemDate.create(vote, endAt.minusDays(1)) }
            .withMessage("투표 종료 시간보다 이른 시간을 선택할 수 없습니다.")
    }
}