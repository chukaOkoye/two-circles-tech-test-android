package com.chrissloan.superscoreboard.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Team(
    @SerialName("name")
    val name: String? = null,
    @SerialName("club")
    val club: Club? = null,
    @SerialName("teamType")
    val teamType: String? = null,
    @SerialName("shortName")
    val shortName: String? = null,
    @SerialName("id")
    val id: Int? = null,
    @SerialName("altIds")
    val altIds: AltIds? = null
)
