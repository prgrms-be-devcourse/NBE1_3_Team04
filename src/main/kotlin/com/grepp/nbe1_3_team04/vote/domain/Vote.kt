package com.grepp.nbe1_3_team04.vote.domain

import com.grepp.nbe1_3_team04.global.domain.BaseEntity
import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import org.hibernate.annotations.SQLDelete
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId

@Table(
    indexes = [Index(name = "idx_vote_team_id", columnList = "teamId"), Index(
        name = "idx_vote_member_id",
        columnList = "memberId"
    )]
)
@SQLDelete(sql = "UPDATE vote SET is_deleted = 'TRUE' WHERE vote_id = ?")
@Entity
class Vote private constructor(
    memberId: Long,
    teamId: Long,
    title: String,
    endAt: LocalDateTime
) : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val voteId: Long? = null

    val memberId: Long = memberId

    val teamId: Long = teamId

    @Column(length = 50)
    var title: String = title
        protected set

    var endAt: LocalDateTime = endAt
        protected set

    @Enumerated(EnumType.STRING)
    var voteStatus: VoteStatus = VoteStatus.OPENED
        protected set

    @OneToMany(mappedBy = "vote")
    val voteItems: MutableList<VoteItem> = ArrayList()


    fun addChoice(voteItem: VoteItem) {
        voteItems.add(voteItem)
    }

    fun updateVoteStatusToClose() {
        this.voteStatus = VoteStatus.CLOSED
    }

    fun update(updateTitle: String, updateEndAt: LocalDateTime, memberId: Long) {
        checkWriterFromMemberId(memberId)
        this.title = updateTitle
        this.endAt = updateEndAt
    }

    fun checkWriterFromMemberId(memberId: Long) {
        require(!isNotWriter(memberId)) { "투표 작성자가 아닙니다." }
    }

    private fun isNotWriter(memberId: Long): Boolean {
        return this.memberId != memberId
    }

    val instantEndAt: Instant
        get() = endAt.atZone(ZoneId.systemDefault()).toInstant()

    companion object {
        fun create(memberId: Long, teamId: Long, title: String, endAt: LocalDateTime): Vote {
            validateEndAt(endAt)
            return Vote(memberId, teamId, title, endAt)
        }

        private fun validateEndAt(endAt: LocalDateTime) {
            require(!endAt.isBefore(LocalDateTime.now())) { "투표 종료일은 현재 시간 이후여야 합니다." }
        }
    }
}
