package com.imrul.replog.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object FirstScreen : BottomBarScreen(
        "first_screen",
        "First",
        Icons.Default.Home
    )

    object SecondScreen : BottomBarScreen(
        "second_screen",
        "Second",
        Icons.Default.Search
    )

    object ThirdScreen : BottomBarScreen(
        "third_screen",
        "Third",
        Icons.Default.Favorite
    )

    object FourthScreen : BottomBarScreen(
        "fourth_screen",
        "Fourth",
        Icons.Default.Person
    )
}