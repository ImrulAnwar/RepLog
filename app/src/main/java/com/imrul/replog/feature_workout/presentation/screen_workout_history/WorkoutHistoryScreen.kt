package com.imrul.replog.feature_workout.presentation.screen_workout_history

import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.imrul.replog.core.Routes
import com.imrul.replog.core.Strings
import com.imrul.replog.feature_workout.presentation.screen_workout.WorkoutService
import com.imrul.replog.feature_workout.presentation.screen_workout_history.components.WorkoutItem
import com.imrul.replog.ui.theme.WhiteCustom
import com.imrul.replog.ui.theme.Maroon70

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WorkoutHistoryScreen(
    navController: NavHostController,
    workoutHistoryViewModel: WorkoutHistoryViewModel = hiltViewModel(),
//    workoutViewModel: WorkoutViewModel = hiltViewModel(),
) {
    LaunchedEffect(Unit) {
        workoutHistoryViewModel.getAllWorkouts()
    }
//    val elapsedTime = workoutViewModel.elapsedTime
//    val workoutTitle = workoutViewModel.workoutTitle
    val workoutListState by workoutHistoryViewModel.workoutListState.collectAsState()
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = WhiteCustom
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
            onClick = {
                navController.navigate(Routes.ScreenWorkout)
                // start service
                Intent(context, WorkoutService::class.java).also {
                    it.action = WorkoutService.Actions.START.toString()
                    context.startForegroundService(it)
                }
            },
            colors = ButtonColors(
                containerColor = Maroon70,
                contentColor = WhiteCustom,
                disabledContentColor = Maroon70,
                disabledContainerColor = WhiteCustom
            ),
            modifier = Modifier.padding(10.dp)
        ) {
            Text(
                text = Strings.START_EMPTY_WORKOUT
            )

        }
    }
}