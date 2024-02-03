package com.imrul.replog.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null
) {
    object TodayScreen : BottomBarScreen(
        title = "Today",
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home,
        hasNews = false,
    )

    object ProgressScreen : BottomBarScreen(
        title = "Progress",
        selectedIcon = Icons.Filled.Email,
        unselectedIcon = Icons.Outlined.Email,
        hasNews = false,
        badgeCount = 45
    )

    object HistoryScreen : BottomBarScreen(
        title = "History",
        selectedIcon = Icons.Filled.Settings,
        unselectedIcon = Icons.Outlined.Settings,
        hasNews = true,
    )
}