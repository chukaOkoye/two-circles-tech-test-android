package com.chrissloan.superscoreboard.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Kickoff(
    @SerialName("completeness")
    val completeness: Int? = null,
    @SerialName("millis")
    val millis: Long? = null,
    @SerialName("label")
    val label: String? = null
)
