package com.chrissloan.superscoreboard.model


import kotlinx.serialization.Serializable

@Serializable
data class Fixtures(
    val fixtures: List<Fixture>
) {
    companion object {
        val Empty = Fixtures(emptyList())
    }
}
