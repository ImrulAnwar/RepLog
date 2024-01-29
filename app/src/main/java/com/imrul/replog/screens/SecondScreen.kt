package com.imrul.replog.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SecondScreen() {
    Text(text = "Second Screen", modifier = Modifier.fillMaxSize().padding(16.dp))
}