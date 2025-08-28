package com.chrissloan.superscoreboard.fixtures.domain

import com.chrissloan.superscoreboard.model.Fixture

data class FixtureUIModel (
    val homeAbbr: String,
    val awayAbbr: String,
    val homeScore: String,
    val awayScore: String,
    val kickoffTime: String,
    val clockText: String,
    val fixture: Fixture
)
