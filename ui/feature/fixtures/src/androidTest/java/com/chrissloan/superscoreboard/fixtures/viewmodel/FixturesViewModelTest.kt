package com.chrissloan.superscoreboard.fixtures.viewmodel

import com.chrissloan.superscoreboard.fixtures.domain.FixtureActivityUIState
import com.chrissloan.superscoreboard.fixtures.FixtureListRepository
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class FixturesViewModelTest {

    /**
     * In a production app, I would have tested the ViewModel interactions, had issues with the test folder
     * (the DI framework can help with the setup here)
     */


    private val repository: FixtureListRepository = mockk()
    private lateinit var viewModel: FixturesViewModel


//    @Test
//    fun `on init sets loading state`() = runTest {
//        viewModel = FixturesViewModel(repository)
//
//        assertThat(viewModel.uiState.first()).isEqualTo(FixtureActivityUIState.Loading)
//    }

}