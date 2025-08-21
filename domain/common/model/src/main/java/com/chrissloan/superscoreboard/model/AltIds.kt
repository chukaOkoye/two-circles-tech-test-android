package com.chrissloan.superscoreboard.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AltIds(
    @SerialName("opta")
    val opta: String? = null
)
