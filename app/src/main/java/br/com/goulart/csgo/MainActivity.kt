package br.com.goulart.csgo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import br.com.goulart.csgo.core.intent.core.NavigationManager
import br.com.goulart.csgo.core.intent.graph.AppNavigation
import br.com.goulart.csgo.core.uikit.theme.CSGOTheme
import br.com.goulart.csgo.core.uikit.theme.CSGOTheme.colors
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navManager: NavigationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            CSGOTheme {
                Surface(
                    color = colors.backgroundColor,
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    AppNavigation(navController = navController, navManager = navManager)
                }
            }
        }
    }
}
