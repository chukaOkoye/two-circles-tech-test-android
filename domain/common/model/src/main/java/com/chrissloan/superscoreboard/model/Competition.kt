package com.chrissloan.superscoreboard.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Competition(
    @SerialName("id")
    val id: Int? = null,
    @SerialName("title")
    val title: String? = null
)
