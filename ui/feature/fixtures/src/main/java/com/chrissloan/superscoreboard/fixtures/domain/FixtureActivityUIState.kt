package com.chrissloan.superscoreboard.fixtures.domain


sealed class FixtureActivityUIState {
    data object Loading : FixtureActivityUIState()
    data class Success(
        val fixtures: List<CompetitionSection>
    ) : FixtureActivityUIState()
    data class Error(val message: String) : FixtureActivityUIState()
}