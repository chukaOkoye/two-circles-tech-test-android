package tests

import com.chrissloan.superscoreboard.fixtures.FixtureActivityUIState
import com.chrissloan.superscoreboard.fixtures.FixtureListRepository
import com.chrissloan.superscoreboard.fixtures.viewmodel.FixturesViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first

@OptIn(ExperimentalCoroutinesApi::class)
class FixturesViewModelTest {

    private lateinit var viewModel: FixturesViewModel
    private val repository: FixtureListRepository = mockk(relaxed = true)

    @get:Rule
    val coroutineTestRule = MainCoroutineRule()


//    @Before
//    fun setUp() {
//        fixtureListRepository = FixtureListRepositoryImpl(mockk())
//    }

    @Before
    fun setUp() {
        viewModel = FixturesViewModel(repository)
    }

    @Test
    fun `initialise loading state`() = runTest {
        viewModel = FixturesViewModel(repository)

        assertThat(viewModel.uiState.first()).isEqualTo(FixtureActivityUIState.Loading)

    }
}