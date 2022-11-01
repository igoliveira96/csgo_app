package br.com.goulart.csgo.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.goulart.csgo.core.uikit.R as RUiKit
import br.com.goulart.csgo.core.uikit.theme.CSGOTheme.colors
import br.com.goulart.csgo.core.uikit.utils.*
import br.com.goulart.csgo.data.match.model.*
import br.com.goulart.csgo.utils.MatchStatus
import coil.compose.AsyncImage
import coil.request.ImageRequest
import java.util.*

@Composable
fun MatchCard(match: Match) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        backgroundColor = colors.yankeesBlue,
    ) {
        Column {
            match.beginAt.toDate()?.let { date ->
                MatchTime(match.status, date)
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Teams(match.opponents)
            }
            Divider(color = colors.white20Percent, thickness = 1.dp)
            League(match.league, match.leagueSerie)
        }
    }
}

@Composable
private fun MatchTime(status: String, date: Date) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End
    ) {
        Surface(
            shape = RoundedCornerShape(bottomStart = 16.dp, topEnd = 24.dp),
            color = if (status == MatchStatus.RUNNING.value) colors.imperialRed else colors.lotion20Percent
        ) {
            Text(
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                color = Color.White,
                style = TextStyle.Default.copy(
                    fontSize = 8.sp,
                    fontWeight = FontWeight.W700
                ),
                text = when(status) {
                    MatchStatus.RUNNING.value -> "AGORA"
                    else -> if (date.isDayOfThisWeek()) date.toEventTime() else date.toShortDate()
                },
            )
        }
    }
}

@Composable
private fun Teams(opponents: List<Opponents>) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TeamLogo(opponents.first().opponent)
        Text(
            modifier = Modifier.padding(horizontal = 24.dp),
            text = "vs",
            color = colors.white50Percent
        )
        TeamLogo(opponents.last().opponent)
    }
}

@Composable
private fun TeamLogo(opponent: Opponent) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(opponent.imageUrl)
                .crossfade(true)
                .build(),
            placeholder = painterResource(RUiKit.drawable.ic_team_logo),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier.size(60.dp)
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = opponent.name ?: "",
            color = Color.White,
            style = TextStyle.Default.copy(
                fontSize = 12.sp,
                fontWeight = FontWeight.W400
            )
        )
    }
}

@Composable
private fun League(league: League, leagueSerie: LeagueSerie) {
    Row(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(league.imageUrl)
                .crossfade(true)
                .build(),
            placeholder = painterResource(RUiKit.drawable.ic_team_logo),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "${league.name} + ${leagueSerie.name}",
            color = Color.White
        )
    }
}