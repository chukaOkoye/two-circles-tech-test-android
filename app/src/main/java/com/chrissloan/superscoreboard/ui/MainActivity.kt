@file:OptIn(ExperimentalMaterial3AdaptiveApi::class)

package com.chrissloan.superscoreboard.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.chrissloan.superscoreboard.fixtures.screens.FixturesScreen
import com.chrissloan.superscoreboard.theme.SuperScoreBoardTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SuperScoreBoardTheme {
                SuperScoreBoard()
            }
        }
    }
}

@Composable
fun SuperScoreBoard() {
    Scaffold(modifier = Modifier.background(Color.White)) { paddingValues ->
        FixturesScreen(modifier = Modifier.padding(paddingValues))
    }
}
