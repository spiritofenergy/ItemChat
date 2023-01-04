package com.kodex.itemchat

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

sealed class NavRoute(var route: String) {
    object Login: NavRoute(route = Constants.Screens.LOGIN_SCREEN)
    object Chat: NavRoute(route = Constants.Screens.CHAT_SCREEN)
    object Home: NavRoute(route = Constants.Screens.HOME_SCREEN)
}

@Composable
fun Navigation(navController: NavHostController){
    NavHost(navController = navController, startDestination = NavRoute.Home.route){
        composable(NavRoute.Home.route){
            HomeScreen(navController = navController)
        }
        composable(NavRoute.Login.route){
            LoginScreen(navController = navController)
        }
    }
}


