package com.chrissloan.superscoreboard.fixtures.viewmodel

import android.R.id.home
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chrissloan.superscoreboard.fixtures.domain.FixtureActivityUIState
import com.chrissloan.superscoreboard.fixtures.FixtureListRepository
import com.chrissloan.superscoreboard.fixtures.domain.CompetitionSection
import com.chrissloan.superscoreboard.fixtures.domain.FixtureUIModel
import com.chrissloan.superscoreboard.fixtures.screens.extractTime
import com.chrissloan.superscoreboard.model.Fixture
import com.chrissloan.superscoreboard.model.Fixtures
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class FixturesViewModel(
    private val fixtureListRepository: FixtureListRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow<FixtureActivityUIState>(FixtureActivityUIState.Loading)
    val uiState = _uiState.asStateFlow()

    fun fetchFixtures() {
        _uiState.value = FixtureActivityUIState.Loading

        viewModelScope.launch {
            fixtureListRepository.getFixtures()
                .collectLatest { result ->
                    result.onSuccess { fixtures ->
                        val sections = groupByCompetition(fixtures)
                        _uiState.value =
                            if (sections.isEmpty()) {
                                FixtureActivityUIState.Success(fixtures = emptyList())
                            } else {
                                FixtureActivityUIState.Success(fixtures = sections)
                            }
                    }
                        .onFailure { e ->
                            _uiState.value = FixtureActivityUIState.Error(
                                message = e.message ?: "Something went wrong"
                            )
                        }
                }
        }
    }

    private fun groupByCompetition(matches: Fixtures): List<CompetitionSection> {
        val list = matches.fixtures
        if (list.isEmpty()) return emptyList()

        return list
            .groupBy { it.competition?.title }
            .map { (competition, group) ->
                CompetitionSection(
                    competition = competition,
                    fixtures = group.sortedByDescending { it.kickoff?.label }.map {
                        mapToFixtureUI(it)
                    }
                )
            }
    }

    private fun mapToFixtureUI(fixture: Fixture): FixtureUIModel {
        val homeAbbr = fixture.fixtureTeams?.getOrNull(0)?.team?.club?.abbr ?: "—"
        val awayAbbr = fixture.fixtureTeams?.getOrNull(1)?.team?.club?.abbr ?: "—"
        val kickoffTime = fixture.kickoff?.label?.let(::extractTime) ?: "-"
        val clockText = fixture.clock?.label ?: ""
        val homeScore = fixture.fixtureTeams?.getOrNull(0)?.score.toString()
        val awayScore = fixture.fixtureTeams?.getOrNull(0)?.score.toString()

        return FixtureUIModel(
            homeAbbr = homeAbbr,
            awayAbbr = awayAbbr,
            homeScore = homeScore,
            awayScore = awayScore,
            kickoffTime = kickoffTime,
            fixture = fixture,
            clockText = clockText
        )
    }
}
