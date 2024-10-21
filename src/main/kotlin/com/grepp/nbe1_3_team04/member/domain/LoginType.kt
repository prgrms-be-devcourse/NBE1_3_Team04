package com.grepp.nbe1_3_team04.member.domain

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated

@Embeddable
class LoginType (
    loginProvider: LoginProvider,
    snsId: String?) {

    @Enumerated(EnumType.STRING)
    val loginProvider: LoginProvider = loginProvider

    @Column(nullable = true)
    val snsId: String? = snsId

}
