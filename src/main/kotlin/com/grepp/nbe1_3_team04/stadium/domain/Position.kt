package com.grepp.nbe1_3_team04.stadium.domain

import jakarta.persistence.Column
import jakarta.persistence.Embeddable


@Embeddable
class Position private constructor(
    latitude: Double,
    longitude: Double,
) {
    @Column(nullable = false)
    var latitude: Double = latitude
        protected set

    @Column(nullable = false)
    var longitude: Double = longitude
        protected set

    fun updatePosition(latitude: Double, longitude: Double) {
        this.latitude = latitude
        this.longitude = longitude
    }

    companion object {
        fun of(latitude: Double, longitude: Double): Position {
            return Position(latitude, longitude)
        }
    }
}