package com.imrul.replog.feature_workout.presentation.screen_workout_history

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.imrul.replog.core.Routes
import com.imrul.replog.feature_workout.presentation.screen_workout_history.components.WorkoutItem
import com.imrul.replog.ui.theme.Maroon10
import com.imrul.replog.ui.theme.Maroon20
import com.imrul.replog.ui.theme.Maroon70
import java.util.Date

@Composable
fun WorkoutHistoryScreen(
    navController: NavHostController,
    workoutHistoryViewModel: WorkoutHistoryViewModel = hiltViewModel()
) {
    LaunchedEffect(Unit) {
        workoutHistoryViewModel.getAllWorkouts()
    }
    val workoutListState by workoutHistoryViewModel.workoutListState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Maroon10
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ) {
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
        ) {
            items(workoutListState) { workout ->
                WorkoutItem(workout)
            }
        }
        Button(
            onClick = { navController.navigate(Routes.ScreenWorkout) },
            colors = ButtonColors(
                containerColor = Maroon70,
                contentColor = Maroon10,
                disabledContentColor = Maroon70,
                disabledContainerColor = Maroon10
            )
        ) {
            Text(
                text = "Start an empty workout"
            )

        }
    }
}