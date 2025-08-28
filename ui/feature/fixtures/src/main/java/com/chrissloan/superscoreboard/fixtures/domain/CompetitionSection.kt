package com.chrissloan.superscoreboard.fixtures.domain

import com.chrissloan.superscoreboard.model.Fixture

data class CompetitionSection(
    val competition: String?,
    val fixtures: List<Fixture>
)