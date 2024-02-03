package com.imrul.replog.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.imrul.replog.ui.today.TodayScreen
import com.imrul.replog.ui.history.HistoryScreen
import com.imrul.replog.ui.progress.ProgressScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController,
        startDestination = BottomBarScreen.TodayScreen.title
    ) {
        composable(BottomBarScreen.TodayScreen.title) { TodayScreen() }
        composable(BottomBarScreen.ProgressScreen.title) { HistoryScreen() }
        composable(BottomBarScreen.HistoryScreen.title) { ProgressScreen() }
    }
}