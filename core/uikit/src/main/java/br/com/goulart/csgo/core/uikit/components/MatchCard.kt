package br.com.goulart.csgo.core.uikit.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.goulart.csgo.core.uikit.R
import br.com.goulart.csgo.core.uikit.theme.CSGOTheme.colors

@Composable
fun MatchCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        backgroundColor = colors.yankeesBlue,
    ) {
        Column {
            MatchTime("Hoje, 21:00")
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Teams()
            }
            Divider(color = colors.white20Percent, thickness = 1.dp)
            League()
        }
    }
}

@Composable
private fun MatchTime(
    text: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End
    ) {
        Surface(
            shape = RoundedCornerShape(bottomStart = 24.dp, topEnd = 24.dp),
            color = colors.lotion20Percent
        ) {
            Text(
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                color = Color.White,
                style = TextStyle.Default.copy(
                  fontSize = 12.sp,
                    fontWeight = FontWeight.W700
                ),
                text = text,
            )
        }
    }
}

@Composable
private fun Teams() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TeamLogo()
        Text(
            modifier = Modifier.padding(horizontal = 24.dp),
            text = "vs",
            color = colors.white50Percent
        )
        TeamLogo()
    }
}

@Composable
private fun TeamLogo() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.size(60.dp),
            painter = painterResource(id = R.drawable.ic_team_logo),
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Team name",
            color = Color.White,
            style = TextStyle.Default.copy(
                fontSize = 12.sp,
                fontWeight = FontWeight.W400
            )
        )
    }
}

@Composable
private fun League() {
    Row(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier.size(24.dp),
            painter = painterResource(id = R.drawable.ic_team_logo),
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "League + serie",
            color = Color.White
        )
    }
}

@Preview
@Composable
private fun MatchCardPreview() {
    Row(
        modifier = Modifier.padding(8.dp)
    ) {
        MatchCard()
    }
}