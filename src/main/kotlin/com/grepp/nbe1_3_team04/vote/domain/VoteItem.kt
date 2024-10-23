package com.grepp.nbe1_3_team04.vote.domain

import jakarta.persistence.*

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn
@Entity
class VoteItem(
    vote: Vote
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val voteItemId: Long? = null

    @JoinColumn(name = "vote_id")
    @ManyToOne(fetch = FetchType.LAZY)
    val vote: Vote = vote

    init {
        vote.addChoice(this)
    }

}
