package com.chrissloan.superscoreboard.fixtures

import com.chrissloan.superscoreboard.model.Fixtures
import kotlinx.coroutines.flow.Flow

interface FixtureListRepository {
    fun getFixtures(): Flow<Fixtures>
}
