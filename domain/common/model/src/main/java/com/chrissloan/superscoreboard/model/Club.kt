package com.chrissloan.superscoreboard.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Club(
    @SerialName("name")
    val name: String? = null,
    @SerialName("abbr")
    val abbr: String? = null,
    @SerialName("id")
    val id: Int? = null,
    @SerialName("shortName")
    val shortName: String? = null
)
