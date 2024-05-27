package com.imrul.replog.feature_workout.presentation.screen_workout.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.imrul.replog.core.presentation.components.NoteTextField
import com.imrul.replog.core.presentation.components.TitleTextField
import com.imrul.replog.feature_workout.presentation.screen_workout.WorkoutViewModel
import com.imrul.replog.ui.theme.Maroon70

@Composable
fun ExerciseItem(
    exerciseIndex: Int,
    workoutViewModel: WorkoutViewModel = hiltViewModel()
) {
    val listOfExercises = workoutViewModel.listOfExercises
    val listOfWeights = workoutViewModel.listOfWeights
    val listOfReps = workoutViewModel.listOfReps
    val listOfNotes = workoutViewModel.listOfNotes
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TitleTextField(
            text = listOfExercises[exerciseIndex],
            onValueChange = {
                workoutViewModel.onExerciseNameValueChanged(
                    exerciseIndex = exerciseIndex,
                    content = it
                )
            },
        )
        NoteTextField(
            text = listOfNotes[exerciseIndex],
            onValueChange = {
                workoutViewModel.onNoteValueChanged(
                    exerciseIndex = exerciseIndex,
                    content = it
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp, 0.dp)
        )
        listOfWeights.forEachIndexed { setIndex, item ->
            if (item.first == exerciseIndex) {
                SetItem(exerciseIndex = exerciseIndex, setIndex = setIndex)
            }
        }
        Text(
            text = "Add Set",
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            modifier = Modifier
                .padding(10.dp)
                .clickable {
                    workoutViewModel.addSet("", "", exerciseIndex = exerciseIndex)
                },
            color = Maroon70
        )
    }
}
