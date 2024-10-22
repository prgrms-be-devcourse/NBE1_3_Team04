package com.grepp.nbe1_3_team04.stadium.domain

import jakarta.persistence.Column
import jakarta.persistence.Embeddable


@Embeddable
class Position(
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
}