package com.chrissloan.superscoreboard.data.fixtures

import com.chrissloan.superscoreboard.fixtures.FixtureListRepository
import com.chrissloan.superscoreboard.model.Fixtures
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.coroutines.cancellation.CancellationException

class FixtureListRepositoryImpl(
    private val fixturesApi: FixturesApi,
) : FixtureListRepository {

    override fun getFixtures(): Flow<Result<Fixtures>> = flow {
        try {
            val response = fixturesApi.getFixtures()
            if (response != null) {
                emit(Result.success(response))
            } else {
                emit(Result.failure(IllegalStateException("API returned null")))
            }
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }
}
