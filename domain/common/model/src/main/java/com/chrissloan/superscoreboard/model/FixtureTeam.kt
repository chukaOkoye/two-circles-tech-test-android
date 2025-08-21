package com.chrissloan.superscoreboard.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FixtureTeam(
    @SerialName("team")
    val team: Team? = Team(),
    @SerialName("score")
    val score: Int? = 0
)
