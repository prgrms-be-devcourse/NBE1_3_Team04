package com.grepp.nbe1_3_team04.chat.service.event

@JvmRecord
data class ReservationPublishedEvent(
    val name: String,
    val reservationId: Long
)
