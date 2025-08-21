package com.chrissloan.superscoreboard.data.fixtures

import com.chrissloan.superscoreboard.model.AltIds
import com.chrissloan.superscoreboard.model.Clock
import com.chrissloan.superscoreboard.model.Club
import com.chrissloan.superscoreboard.model.Competition
import com.chrissloan.superscoreboard.model.Fixture
import com.chrissloan.superscoreboard.model.FixtureTeam
import com.chrissloan.superscoreboard.model.Goal
import com.chrissloan.superscoreboard.model.Ground
import com.chrissloan.superscoreboard.model.Kickoff
import com.chrissloan.superscoreboard.model.Team

val homeTeam = Team(
    name = "Home Team",
    club = Club(
        name = "Home Club",
        abbr = "HTC",
        id = 1,
        shortName = "Home"
    ),
    teamType = "Mens",
    shortName = "Home",
    id = 1,
    altIds = AltIds(opta = "homeOptaId")
)

val awayTeam = Team(
    name = "Away Team",
    club = Club(
        name = "Away Club",
        abbr = "ATC",
        id = 2,
        shortName = "Away"
    ),
    teamType = "Mens",
    shortName = "Away",
    id = 2,
    altIds = AltIds(opta = "awayOptaId")
)

val sampleFixture = Fixture(
    kickoff = Kickoff(
        completeness = 0,
        millis = 1672531200000L,
        label = "2023-01-01T12:00:00Z"
    ),
    competition = Competition(
        id = 100,
        title = "Sample Competition"
    ),
    fixtureTeams = listOf(
        FixtureTeam(homeTeam),
        FixtureTeam(awayTeam),
    ),
    ground = Ground(
        name = "Sample Ground",
        city = "Sample City",
        source = "source",
        id = 300
    ),
    status = "started",
    id = 12345,
    attendance = 50000,
    clock = Clock(
        secs = 3600,
        label = "Full Time"
    ),
    goals = listOf(
        Goal(
            personId = 10,
            assistId = 20,
            clock = Clock(secs = 1800, label = "45+1"),
            phase = "first-half",
            type = "goal",
            description = "Goal scored by player 10"
        )
    )
)
