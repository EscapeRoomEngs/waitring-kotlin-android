package com.escaperoomengs.waitring_kotlin_android.presentation.base.navGraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.escaperoomengs.waitring_kotlin_android.presentation.feature.login.LoginScreen
import com.escaperoomengs.waitring_kotlin_android.presentation.feature.main.MainScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Main.route) {
        composable(route = Screen.Main.route) {
            MainScreen()
        }
        composable(route = Screen.Login.route) {
            LoginScreen()
        }
    }
}

