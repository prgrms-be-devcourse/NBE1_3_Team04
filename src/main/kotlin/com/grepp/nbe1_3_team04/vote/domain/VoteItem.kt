package com.grepp.nbe1_3_team04.vote.domain

import jakarta.persistence.*

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn
@Entity
open class VoteItem(
    @JoinColumn(name = "vote_id")
    @ManyToOne(fetch = FetchType.LAZY)
    val vote: Vote
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val voteItemId: Long? = null

    init {
        vote.addChoice(this)
    }

}
