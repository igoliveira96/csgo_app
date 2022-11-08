package br.com.goulart.csgo

import android.Manifest
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.rule.GrantPermissionRule
import br.com.goulart.csgo.components.MatchCard
import br.com.goulart.csgo.core.uikit.theme.CSGOTheme
import br.com.goulart.csgo.data.match.model.Match
import org.junit.Rule
import org.junit.Test

class MatchCardTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @get:Rule
    val permissionRule: GrantPermissionRule = GrantPermissionRule.grant(
        Manifest.permission.INTERNET
    )

    @Test
    fun testTeamNameDisplay() {
        // WHEN
        val match = Match.EXAMPLE

        // GIVEN
        composeTestRule.setContent {
            CSGOTheme {
                MatchCard(match)
            }
        }

        // THEN
        match.opponents.first().opponent.name?.let { name ->
            composeTestRule.onNodeWithText(name).assertIsDisplayed()
        }
        match.opponents.last().opponent.name?.let { name ->
            composeTestRule.onNodeWithText(name).assertIsDisplayed()
        }
    }

    @Test
    fun testLeagueNameDisplay() {
        // WHEN
        val match = Match.EXAMPLE

        // GIVEN
        composeTestRule.setContent {
            CSGOTheme {
                MatchCard(match)
            }
        }

        // THEN
        composeTestRule.onNodeWithText(
            "${match.league.name} + ${match.leagueSerie.name}"
        ).assertIsDisplayed()
    }

}