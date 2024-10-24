package com.grepp.nbe1_3_team04.reservation.domain

import com.grepp.nbe1_3_team04.global.domain.BaseEntity
import jakarta.persistence.*
import org.hibernate.annotations.SQLDelete

@SQLDelete(sql = "UPDATE mercenary SET is_deleted = 'TRUE' WHERE mercenary_id = ?")
@Entity
class Mercenary private constructor(
    reservation: Reservation,
    description: String?
) : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val mercenaryId: Long? = null

    @JoinColumn(name = "reservation_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    var reservation: Reservation = reservation
        protected set

    @field:Column(length = 200, nullable = true)
    var description: String? = description
        protected set

    companion object {
        fun create(reservation: Reservation, description: String?): Mercenary {
            return Mercenary(
                reservation = reservation,
                description = description
            )
        }

        fun createDefault(reservation: Reservation): Mercenary {
            return Mercenary(
                reservation = reservation,
                description = ("기본 설명")
            )
        }
    }
}
