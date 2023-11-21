package com.kotlin.moonlightbarapp.ui.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kotlin.moonlightbarapp.ui.moonlightBar.CocktailTopBar
import com.kotlin.moonlightbarapp.ui.moonlightBar.FavoriteCocktail
import com.kotlin.moonlightbarapp.ui.moonlightBar.PieDePagina



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            PieDePagina(navController = navController)
        },
        content = { padding ->
            Box(modifier = Modifier.padding(padding)) {
                AppNavigation(navController = navController)
            }
        }
    )
}

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController, startDestination = Destination.MoonBar.route) {
        composable(Destination.MoonBar.route) {
            CocktailTopBar()
        }
        composable(Destination.Categoria.route) {
            CocktailTopBar()
        }
        composable(Destination.Favoritos.route) {
            FavoriteCocktail()
        }
    }
}
