package com.grepp.nbe1_3_team04.chat.service.event

@JvmRecord
data class TeamPublishedEvent(
    val name: String,
    val teamId: Long
)
