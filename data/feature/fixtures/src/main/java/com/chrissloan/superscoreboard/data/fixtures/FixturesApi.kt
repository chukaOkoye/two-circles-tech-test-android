package com.chrissloan.superscoreboard.data.fixtures

import com.chrissloan.superscoreboard.data.network.BaseApi
import com.chrissloan.superscoreboard.model.Fixtures
import com.chrissloan.superscoreboard.model.Fixture

class FixturesApi : BaseApi() {

    suspend fun getFixtures(): Fixtures? =
        fetch<List<Fixture>>("fixtures.json")?.let {
            Fixtures(it)
        }
}
