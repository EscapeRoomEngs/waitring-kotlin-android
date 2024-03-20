package com.escaperoomengs.waitring_kotlin_android.presentation.feature.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun MainScreen() {
    MainView()
}

@Composable
private fun MainView(){

    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNav(navController = navController) }
    ) {
        Box(modifier = Modifier.padding(it)){
            MainBottomNavGraph(navController = navController)
        }
    }
}

@Composable
private fun BottomNav(navController: NavController){

    val items = listOf(
        MainBottomNavItem.Heart,
        MainBottomNavItem.Search,
        MainBottomNavItem.Home,
        MainBottomNavItem.Reserved,
        MainBottomNavItem.More
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    BottomNavigation(backgroundColor = Color.White) {
        items.map { item ->
            BottomNavigationItem(
                modifier = Modifier.height(75.dp),
                icon = { Icon(painter = painterResource(id = item.icon), contentDescription =  item.route, modifier = Modifier.padding(bottom=6.dp).size(24.dp))},
                label = { Text(stringResource(id = item.name)) },
                selected = currentRoute == item.route,
                selectedContentColor = Color(0xFFFF3D00),
                unselectedContentColor = Color(0xFF191919),
                onClick = {
                    navController.navigate(item.route){
                        navController.graph.startDestinationRoute?.let {
                            popUpTo(it) { saveState = true }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Preview
@Composable
private fun MainBottomNavPreview(){
    BottomNav(rememberNavController())
}

@Preview
@Composable
private fun MainViewPreview(){
    MainView()
}