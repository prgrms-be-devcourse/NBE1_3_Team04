package com.grepp.nbe1_3_team04.chat.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.validation.constraints.NotNull

@Entity
class TeamChatroom private constructor(
    name: String,
    teamId: Long
) : Chatroom(name) {

    @field:NotNull
    @Column(nullable = false)
    var teamId: Long = teamId
        protected set

    companion object {
        fun create(name: String, teamId: Long): TeamChatroom {
            return TeamChatroom(name, teamId)
        }
    }
}
