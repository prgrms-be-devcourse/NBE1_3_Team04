package com.grepp.nbe1_3_team04.chat.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.validation.constraints.NotNull

@Entity
class ReservationChatroom private constructor(
    name: String,
    reservationId: Long
) : Chatroom(name) {

    @field:NotNull
    @Column(nullable = false)
    var reservationId: Long = reservationId
        protected set

    companion object {
        fun create(name: String, reservationId: Long): ReservationChatroom {
            return ReservationChatroom(name, reservationId)
        }
    }
}
