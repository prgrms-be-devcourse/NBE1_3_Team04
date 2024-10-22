package com.grepp.nbe1_3_team04.chat.domain

import jakarta.persistence.Entity

@Entity
class ReservationChatroom (
    name: String,
    reservationId: Long
) : Chatroom(name) {

    var reservationId: Long = reservationId
        protected set

    companion object {
        fun create(name: String, reservationId: Long): ReservationChatroom {
            return ReservationChatroom(name, reservationId)
        }
    }
}
