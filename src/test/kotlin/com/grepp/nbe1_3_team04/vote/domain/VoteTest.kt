package com.grepp.nbe1_3_team04.vote.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

internal class VoteTest {

    @DisplayName("투표 생성")
    @Test
    fun createVote() {
        //given
        val tomorrowDateTime = LocalDateTime.now().plusDays(1)

        //when
        val vote = Vote.create(1L, 1L, "투표 제목", tomorrowDateTime)

        //then
        Assertions.assertThat(vote).isNotNull()
    }

    @DisplayName("투표 생성시 현재의 시간보다 이전의 시간이 들어오면 예외가 발생한다.")
    @Test
    fun createVoteWhenPastDateTimeIsThrownException() {
        //given
        val pastDateTime = LocalDateTime.now().minusDays(1)
        //when
        //then
        Assertions.assertThatThrownBy { Vote.create(1L, 1L, "투표 제목", pastDateTime) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("투표 종료일은 현재 시간 이후여야 합니다.")
    }

    @DisplayName("투표 수정시 제목과 종료일이 변경된다.")
    @Test
    fun updateVote() {
        //given
        val vote: Vote = Vote.create(1L, 1L, "투표 제목", LocalDateTime.now().plusDays(1))
        val tomorrowDateTime = LocalDateTime.now().plusDays(2)
        //when
        vote.update("수정된 투표", tomorrowDateTime, 1L)
        //then
        Assertions.assertThat(vote)
            .extracting("title", "endAt")
            .containsExactly("수정된 투표", tomorrowDateTime)
    }

    @DisplayName("투표 수정시 투표 생성자가 아니면 투표를 변경 할 수 없다.")
    @Test
    fun updateVoteWhenMemberIdNotEqualThrowException() {
        //given
        val vote: Vote = Vote.create(1L, 1L, "투표 제목", LocalDateTime.now().plusDays(1))
        val tomorrowDateTime = LocalDateTime.now().plusDays(2)
        //when
        //then
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy { vote.update("수정된 투표", tomorrowDateTime, 2L) }
            .withMessage("투표 작성자가 아닙니다.")
    }

    @DisplayName("투표 생성자와 수정 또는 삭제하려는 회원이 같은지 확인한다.")
    @Test
    fun checkVoteAuthor() {
        //given
        val vote: Vote = Vote.create(1L, 1L, "투표 제목", LocalDateTime.now().plusDays(1))
        //when
        //then
        org.junit.jupiter.api.Assertions.assertDoesNotThrow { vote.checkWriterFromMemberId(1L) }
    }

    @DisplayName("투표 생성자와 수정 또는 삭제하려는 회원이 같은지 확인한다.")
    @Test
    fun checkVoteAuthorWhenAuthorIsDifferentThrowException() {
        //given
        val vote: Vote = Vote.create(1L, 1L, "투표 제목", LocalDateTime.now().plusDays(1))
        //when
        //then
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy { vote.checkWriterFromMemberId(4L) }
            .withMessage("투표 작성자가 아닙니다.")
    }

    @DisplayName("투표 상태를 마감 상태로 변경한다.")
    @Test
    fun updateVoteStatusToClose() {
        //given
        val vote: Vote = Vote.create(1L, 1L, "투표 제목", LocalDateTime.now().plusDays(1))
        //when
        vote.updateVoteStatusToClose()
        //then
        Assertions.assertThat(vote.voteStatus).isEqualTo(VoteStatus.CLOSED)
    }
}