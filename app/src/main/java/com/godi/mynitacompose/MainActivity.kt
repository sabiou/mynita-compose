package com.godi.mynitacompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.godi.mynitacompose.navigation.NavigationItem
import com.godi.mynitacompose.ui.screens.AirtimeScreen
import com.godi.mynitacompose.ui.screens.CardsScreen
import com.godi.mynitacompose.ui.screens.HomeScreen
import com.godi.mynitacompose.ui.screens.NumPadTopUpScreen
import com.godi.mynitacompose.ui.screens.RecipientDetails
import com.godi.mynitacompose.ui.screens.SendMoneyScreen
import com.godi.mynitacompose.ui.screens.SuccessScreen
import com.godi.mynitacompose.ui.screens.TopUpDetailsScreen
import com.godi.mynitacompose.ui.theme.MyNitaComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyNitaComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    Scaffold(
        content = { padding ->
            Box(modifier = Modifier.padding(padding)) {
                MyNitaConnectNavGraph(navController = navController)
            }
        },
    )
}

/**
 * Composable function that defines the navigation graph for MyNitaCompose app.
 *
 * @param navController The NavHostController used for navigation.
 */
@Composable
fun MyNitaConnectNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavigationItem.Acceuil.route) {
        composable(NavigationItem.Acceuil.route) {
            HomeScreen(navController)
        }
        composable(NavigationItem.Cartes.route) {
            CardsScreen(navController)
        }
        composable(NavigationItem.Scan.route) {

        }
        composable(NavigationItem.Historique.route) {

        }
        composable(NavigationItem.Compte.route) {

        }
        composable("send") {
            SendMoneyScreen(navController = navController)
        }
        composable(
            "recipientDetails/{amount}"
        ) {
            navArgument("amount") { type = NavType.StringType }
            RecipientDetails(navController = navController)
        }
        composable(
            "success"
        ) {
            SuccessScreen(navController = navController)
        }
        composable("airtime") {
            AirtimeScreen(navController = navController)
        }
        composable("topUp") {
            NumPadTopUpScreen(navController = navController)
        }
        composable(
            "topUpDetails/{amount}"
        ) {
            navArgument("amount") { type = NavType.StringType }
            TopUpDetailsScreen(navController = navController)
        }
    }
}