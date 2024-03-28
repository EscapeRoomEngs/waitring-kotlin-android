package com.escaperoomengs.waitring_kotlin_android.presentation.base.navGraph

sealed class Screen(val route: String) {

    data object Main : Screen(route = MAIN)
    data object Login : Screen(route = LOGIN)

    private companion object {
        const val MAIN = "MAIN"
        const val LOGIN = "LOGIN"
    }
}