package com.chrissloan.superscoreboard.fixtures.domain

data class CompetitionSection(
    val competition: String?,
    val fixtures: List<FixtureUIModel>,
    val competitionIcon: Int?
)