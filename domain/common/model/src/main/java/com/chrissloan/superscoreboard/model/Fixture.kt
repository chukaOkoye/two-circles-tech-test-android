package com.chrissloan.superscoreboard.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Fixture(
    @SerialName("kickoff")
    val kickoff: Kickoff? = Kickoff(),
    @SerialName("competition")
    val competition: Competition? = Competition(),
    @SerialName("teams")
    val fixtureTeams: List<FixtureTeam>? = listOf(),
    @SerialName("ground")
    val ground: Ground? = Ground(),
    @SerialName("status")
    val status: String? = "",
    @SerialName("id")
    val id: Int? = 0,
    @SerialName("attendance")
    val attendance: Int? = 0,
    @SerialName("clock")
    val clock: Clock? = Clock(),
    @SerialName("goals")
    val goals: List<Goal>? = listOf()
)
