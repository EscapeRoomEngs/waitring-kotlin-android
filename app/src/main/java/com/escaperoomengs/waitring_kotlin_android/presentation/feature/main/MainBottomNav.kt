package com.escaperoomengs.waitring_kotlin_android.presentation.feature.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.escaperoomengs.waitring_kotlin_android.R
import com.escaperoomengs.waitring_kotlin_android.presentation.feature.home.HomeScreen

@Composable
fun MainBottomNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = MainBottomNavItem.Home.route) {
        composable(MainBottomNavItem.Heart.route) {
            HomeScreen()
        }
        composable(MainBottomNavItem.Search.route) {
            HomeScreen()
        }
        composable(MainBottomNavItem.Home.route) {
            HomeScreen()
        }
        composable(MainBottomNavItem.Reserved.route) {
            HomeScreen()
        }
        composable(MainBottomNavItem.More.route) {
            HomeScreen()
        }
    }
}

sealed class MainBottomNavItem(val name: Int, val icon: Int, val route: String){
    data object Heart: MainBottomNavItem(R.string.main_bottom_heart, R.drawable.ic_heart, HEART)
    data object Search: MainBottomNavItem(R.string.main_bottom_search, R.drawable.ic_search, SEARCH)
    data object Home: MainBottomNavItem(R.string.main_bottom_home, R.drawable.ic_home, HOME)
    data object Reserved: MainBottomNavItem(R.string.main_bottom_reserved, R.drawable.ic_calendar, RESERVED)
    data object More: MainBottomNavItem(R.string.main_bottom_more, R.drawable.ic_menu, MORE)

    private companion object{
        const val HEART = "HEART"
        const val SEARCH = "SEARCH"
        const val HOME = "HOME"
        const val RESERVED = "RESERVED"
        const val MORE = "MORE"
    }
}

