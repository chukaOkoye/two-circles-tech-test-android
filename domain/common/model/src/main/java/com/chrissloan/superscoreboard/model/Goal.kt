package com.chrissloan.superscoreboard.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Goal(
    @SerialName("personId")
    val personId: Int? = 0,
    @SerialName("assistId")
    val assistId: Int? = 0,
    @SerialName("clock")
    val clock: Clock? = Clock(),
    @SerialName("phase")
    val phase: String? = "",
    @SerialName("type")
    val type: String? = "",
    @SerialName("description")
    val description: String? = ""
)
