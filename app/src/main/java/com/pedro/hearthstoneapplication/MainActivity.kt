package com.pedro.hearthstoneapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.pedro.cards_details.presentation.screen.CardsDetailsScreen
import com.pedro.cards_list.presentation.screen.CardsScreen
import com.pedro.designsystem.theme.HearthstoneApplicationTheme
import com.pedro.onboarding.SplashScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HearthstoneApplicationTheme {
                Surface(color = Color.White, modifier = Modifier.fillMaxSize()) {
                    Navigation()
                }
            }
        }
    }
}

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "splash_screen") {

        composable("splash_screen") {
            SplashScreen {
                navController.navigate("cards_screen")
            }
        }

        composable("cards_screen") {
            CardsScreen {
                navController.navigate("card_detail_screen/$it")
            }
        }

        composable(
            "card_detail_screen/{id}",
            arguments = listOf(navArgument("id") { type = NavType.StringType })
        ) { navBackStackEntry ->
            CardsDetailsScreen(itemId = navBackStackEntry.arguments?.getString("id") ?: "")
        }
    }
}