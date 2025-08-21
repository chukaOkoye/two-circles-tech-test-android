package com.chrissloan.superscoreboard.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Ground(
    @SerialName("name")
    val name: String? = null,
    @SerialName("city")
    val city: String? = null,
    @SerialName("source")
    val source: String? = null,
    @SerialName("id")
    val id: Int? = null
)
