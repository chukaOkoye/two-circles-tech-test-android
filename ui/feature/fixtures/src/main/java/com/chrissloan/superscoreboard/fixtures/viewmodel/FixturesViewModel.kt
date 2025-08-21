package com.chrissloan.superscoreboard.fixtures.viewmodel

import androidx.lifecycle.ViewModel
import com.chrissloan.superscoreboard.fixtures.FixtureListRepository

class FixturesViewModel(
    fixtureListRepository: FixtureListRepository,
) : ViewModel() {

    val fixtures = fixtureListRepository.getFixtures()
}
