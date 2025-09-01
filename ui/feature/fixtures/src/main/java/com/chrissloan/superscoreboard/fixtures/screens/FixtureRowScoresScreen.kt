package com.chrissloan.superscoreboard.fixtures.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chrissloan.superscoreboard.fixtures.domain.FixtureUIModel
import com.chrissloan.superscoreboard.model.Fixture
import com.chrissloan.superscoreboard.theme.R

@Composable
fun FixtureRowScores(fixturesUIModel: FixtureUIModel) {

    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colorScheme.surface)
            .padding(horizontal = 12.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TeamBadgeWithName(name = fixturesUIModel.homeAbbr)

        Spacer(Modifier.width(10.dp))

        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                fixturesUIModel.homeScore,
                fontFamily = FontFamily(Font(R.font.druk_wide_bold, FontWeight.Normal)),
                fontSize = 34.sp
            )
        }

        Spacer(Modifier.width(26.dp))

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(4.dp))
                .background(color = Color(191, 31, 37))
                .width(55.dp)
                .padding(horizontal = 10.dp, vertical = 4.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                fixturesUIModel.clockText,
                style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Normal),
                color = Color.White,
                fontSize = 12.sp
            )
        }

        Spacer(Modifier.width(26.dp))

        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                fixturesUIModel.awayScore,
                fontFamily = FontFamily(Font(R.font.druk_wide_bold, FontWeight.Normal)),
                fontSize = 34.sp

            )
        }

        Spacer(Modifier.width(10.dp))

        TeamBadgeWithName(name = fixturesUIModel.awayAbbr)
    }
}

@Composable
private fun TeamBadgeWithName(
    name: String,
    crestSize: Dp = 46.dp
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.widthIn(min = crestSize)
    ) {
        CrestPlaceholder(size = crestSize)
        Spacer(Modifier.height(4.dp))
        Text(
            text = name,
            style = MaterialTheme.typography.labelMedium,
            maxLines = 1,
            textAlign = TextAlign.Center,
            fontSize = 14.sp,
            color = Color(60, 60, 67),
            fontFamily = FontFamily.SansSerif

        )
    }
}
