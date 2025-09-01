package com.chrissloan.superscoreboard.fixtures.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chrissloan.superscoreboard.fixtures.domain.FixtureActivityUIState
import com.chrissloan.superscoreboard.fixtures.viewmodel.FixturesViewModel
import com.chrissloan.superscoreboard.theme.R
import org.koin.androidx.compose.koinViewModel

@Composable
fun FixturesScreen(
    modifier: Modifier = Modifier,
    viewModel: FixturesViewModel = koinViewModel<FixturesViewModel>(),
) {
    val state by viewModel.uiState.collectAsState()

    LaunchedEffect(true) {
        viewModel.fetchFixtures()
    }

    when (state) {
        is FixtureActivityUIState.Loading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        is FixtureActivityUIState.Error -> {
            val message = (state as FixtureActivityUIState.Error).message
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Error loading fixtures: $message",
                        style = MaterialTheme.typography.bodyLarge,
                        textAlign = TextAlign.Center
                    )
                    Spacer(Modifier.height(16.dp))
                    Button(onClick = { viewModel.fetchFixtures() }) {
                        Text("Retry")
                    }
                }
            }
        }

        is FixtureActivityUIState.Success -> {
            val matchInfo = state as FixtureActivityUIState.Success

            LazyColumn(
                modifier = modifier
                    .fillMaxSize()
                    .background(color = Color(246, 243, 243)),
                contentPadding = PaddingValues(vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                matchInfo.fixtures.forEach { section ->
                    // Competition header
                    item(key = section.competition ?: "Other") {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp, vertical = 8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = section.competition ?: "Other",
                                style = MaterialTheme.typography.titleMedium,
                                modifier = Modifier.weight(1f),
                                fontSize = 16.sp,
                                fontFamily = FontFamily.SansSerif
                            )
                            Icon(
                                painter = painterResource(id = R.drawable.competition_arrow),
                                contentDescription = "Go to competition",
                                tint = MaterialTheme.colorScheme.onSurface
                            )
                        }
                    }

                    // Fixtures
                    items(section.fixtures) { fixtureUI ->
                        when (fixtureUI.fixture.status) {
                            "C", "I" -> FixtureRowScores(fixtureUI)
                            "U" -> FixtureRowKickoff(fixtureUI)
                            else -> FixtureRowKickoff(fixtureUI)
                        }
                    }
                }

                // Footer item
                item {
                    Spacer(modifier = Modifier.height(26.dp))
                    FollowFavouritesScreen()
                }
            }
        }


    }
}

@Composable
fun CrestPlaceholder(size: Dp = 46.dp) {
    Box(
        modifier = Modifier
            .size(size)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f))
    )
}
