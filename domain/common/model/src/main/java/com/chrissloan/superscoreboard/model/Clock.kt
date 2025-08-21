package com.chrissloan.superscoreboard.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Clock(
    @SerialName("secs")
    val secs: Int? = null,
    @SerialName("label")
    val label: String? = null
)
