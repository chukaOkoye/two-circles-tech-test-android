package com.chrissloan.superscoreboard.application

import com.chrissloan.superscoreboard.data.fixtures.FixtureListRepositoryImpl
import com.chrissloan.superscoreboard.data.fixtures.FixturesApi
import com.chrissloan.superscoreboard.fixtures.FixtureListRepository
import com.chrissloan.superscoreboard.fixtures.viewmodel.FixturesViewModel
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

object Dependencies {
    val dataDependencies = module {
        factoryOf(::FixturesApi)
    }

    val domainDependencies = module {
        singleOf(::FixtureListRepositoryImpl) { bind<FixtureListRepository>() }
    }

    val uiDependencies = module {
        viewModelOf(::FixturesViewModel)
    }
}
