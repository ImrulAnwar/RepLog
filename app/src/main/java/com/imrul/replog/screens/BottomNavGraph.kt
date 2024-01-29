package com.imrul.replog.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController,
        startDestination = BottomBarScreen.FirstScreen.route
    ) {
        composable(BottomBarScreen.FirstScreen.route) { FirstScreen() }
        composable(BottomBarScreen.SecondScreen.route) { SecondScreen() }
        composable(BottomBarScreen.ThirdScreen.route) { ThirdScreen() }
        composable(BottomBarScreen.FourthScreen.route) { FourthScreen() }
    }
}