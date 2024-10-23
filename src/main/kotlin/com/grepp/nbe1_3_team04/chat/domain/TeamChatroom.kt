package com.grepp.nbe1_3_team04.chat.domain

import jakarta.persistence.Entity

@Entity
class TeamChatroom private constructor(
    name: String,
    teamId: Long
) : Chatroom(name) {

    var teamId: Long = teamId
        protected set

    companion object {
        fun create(name: String, teamId: Long): TeamChatroom {
            return TeamChatroom(name, teamId)
        }
    }
}
