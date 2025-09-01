package com.chrissloan.superscoreboard.fixtures.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chrissloan.superscoreboard.fixtures.domain.FixtureUIModel
import com.chrissloan.superscoreboard.model.Fixture
import com.chrissloan.superscoreboard.theme.R
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

@Composable
fun FixtureRowKickoff(fixturesUIModel: FixtureUIModel) {

    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colorScheme.surface)
            .padding(horizontal = 12.dp, vertical = 26.dp),
        verticalAlignment = CenterVertically
    ) {
        CrestPlaceholder()
        Spacer(Modifier.width(10.dp))

        // Home abbr
        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = CenterVertically
        ) {
            Text(fixturesUIModel.homeAbbr,
            fontFamily = FontFamily(Font(R.font.druk_wide_bold, FontWeight.Normal)),
            fontSize = 16.sp)
        }

        Spacer(Modifier.width(16.dp))

        // Middle kickoff time
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(4.dp))
                .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.1f))
                .padding(horizontal = 10.dp, vertical = 6.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(fixturesUIModel.kickoffTime,
                style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.SemiBold),
                fontSize = 12.sp,
                fontFamily = FontFamily.SansSerif)
        }

        Spacer(Modifier.width(16.dp))

        // Away abbr
        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = CenterVertically
        ) {
            Text(fixturesUIModel.awayAbbr,
                fontFamily = FontFamily(Font(R.font.druk_wide_bold, FontWeight.Normal)),
                fontSize = 16.sp)
        }

        Spacer(Modifier.width(10.dp))
        CrestPlaceholder()
    }
}

fun extractTime(label: String): String {
    val formatter = DateTimeFormatter.ofPattern("EEE dd MMM yyyy, HH:mm z", Locale.ENGLISH)
    val zoned = ZonedDateTime.parse(label, formatter)
    return zoned.toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm"))
}
