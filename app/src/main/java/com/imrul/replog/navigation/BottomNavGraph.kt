package com.imrul.replog.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.imrul.replog.navigation.screens.FirstScreen
import com.imrul.replog.navigation.screens.SecondScreen
import com.imrul.replog.navigation.screens.ThirdScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController,
        startDestination = BottomBarScreen.Home.title
    ) {
        composable(BottomBarScreen.Home.title) { FirstScreen() }
        composable(BottomBarScreen.Chat.title) { SecondScreen() }
        composable(BottomBarScreen.Settings.title) { ThirdScreen() }
    }
}