package com.grepp.nbe1_3_team04.reservation.domain

import com.grepp.nbe1_3_team04.global.domain.BaseEntity
import com.grepp.nbe1_3_team04.member.domain.Member
import jakarta.persistence.*
import org.hibernate.annotations.SQLDelete

@SQLDelete(sql = "UPDATE participant SET is_deleted = 'TRUE' WHERE participant_id = ?")
@Entity
class Participant private constructor(
    reservation: Reservation,
    member: Member,
    participantRole: ParticipantRole
) : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val participantId: Long? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    var member: Member = member
        protected set

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    var participantRole: ParticipantRole = participantRole
        protected set

    @JoinColumn(name = "reservation_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    var reservation: Reservation = reservation
        protected set

    fun updateRole(participantRole: ParticipantRole) {
        this.participantRole = participantRole
    }

    companion object {
        fun create(reservation: Reservation, member: Member, participantRole: ParticipantRole): Participant {
            return Participant(
                reservation = reservation,
                member = member,
                participantRole = participantRole)
        }
    }
}
