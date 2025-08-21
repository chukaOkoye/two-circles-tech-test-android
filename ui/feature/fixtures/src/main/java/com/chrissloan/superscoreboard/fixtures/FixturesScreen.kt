package com.chrissloan.superscoreboard.fixtures

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.chrissloan.superscoreboard.fixtures.viewmodel.FixturesViewModel
import com.chrissloan.superscoreboard.model.Fixtures
import com.chrissloan.superscoreboard.theme.SuperScoreBoardTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun FixturesScreen(
    modifier: Modifier = Modifier,
    viewModel: FixturesViewModel = koinViewModel<FixturesViewModel>(),
) {
    val state by viewModel.fixtures.collectAsStateWithLifecycle(Fixtures.Empty)

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.Start,
        ) {
            item {
                Text(text = "$state", modifier = Modifier.padding(16.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FixturesPreview() {
    SuperScoreBoardTheme {
        FixturesScreen()
    }
}
