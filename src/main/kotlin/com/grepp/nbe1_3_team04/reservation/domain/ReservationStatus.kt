package com.grepp.nbe1_3_team04.reservation.domain


enum class ReservationStatus (private val description: String) {
    CONFIRMED("상대팀과 매치 확정"),
    CANCELLED("예약 취소"),
    RECRUITING("인원이 6명 아니면 RECRUITING"),
    READY("인원이 6명 시작 되면 READY");

}
