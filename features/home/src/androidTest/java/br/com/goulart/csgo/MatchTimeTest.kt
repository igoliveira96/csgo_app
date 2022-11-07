package br.com.goulart.csgo

import android.Manifest
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.rule.GrantPermissionRule
import br.com.goulart.csgo.components.MatchCard
import br.com.goulart.csgo.core.uikit.theme.CSGOTheme
import br.com.goulart.csgo.core.uikit.utils.*
import br.com.goulart.csgo.data.match.model.Match
import org.junit.Rule
import org.junit.Test
import java.time.LocalDateTime

class MatchTimeTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @get:Rule
    val permissionRule: GrantPermissionRule = GrantPermissionRule.grant(
        Manifest.permission.INTERNET
    )

    @Test
    fun testStatusRunning() {
        // WHEN
        val match = Match.EXAMPLE.copy(status = "running")

        // GIVEN
        composeTestRule.setContent {
            CSGOTheme {
                MatchCard(match)
            }
        }

        // THEN
        composeTestRule.onNodeWithText("AGORA").assertIsDisplayed()
    }

    @Test
    fun testShowDateThisWeek() {
        // WHEN
        val localDateTime = LocalDateTime.now()
        val match = Match.EXAMPLE.copy(
            beginAt = localDateTime.format(DEFAULT_DATE_FORMAT)
        )

        // GIVEN
        composeTestRule.setContent {
            CSGOTheme {
                MatchCard(match)
            }
        }

        // THEN
        localDateTime.format(DEFAULT_DATE_FORMAT).toDate()?.let { date ->
            composeTestRule.onNodeWithText(date.toEventTime()).assertIsDisplayed()
        }
    }

    @Test
    fun testShowShortDate() {
        // WHEN
        val localDateTime = LocalDateTime.now()
            .plusDays(15)
            .withHour(20).withMinute(35)

        val match = Match.EXAMPLE.copy(
            beginAt = localDateTime.format(DEFAULT_DATE_FORMAT)
        )

        // GIVEN
        composeTestRule.setContent {
            CSGOTheme {
                MatchCard(match)
            }
        }

        // THEN
        localDateTime.format(DEFAULT_DATE_FORMAT).toDate()?.let { date ->
            composeTestRule.onNodeWithText(date.toShortDate()).assertIsDisplayed()
        }
    }

}