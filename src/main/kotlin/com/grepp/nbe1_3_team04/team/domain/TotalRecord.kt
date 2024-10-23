package com.grepp.nbe1_3_team04.team.domain

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.validation.constraints.NotNull

@Embeddable
class TotalRecord{
    @Column(nullable = false)
    var winCount: Int = 0
        protected set

    @Column(nullable = false)
    var drawCount: Int = 0
        protected set

    @Column(nullable = false)
    var loseCount: Int = 0
        protected set
}