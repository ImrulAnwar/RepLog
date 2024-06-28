package com.imrul.replog.core

import com.imrul.replog.feature_workout.domain.model.Exercise
import kotlinx.serialization.Serializable

open class Routes {
    @Serializable
    object ScreenWorkoutHistory : Routes()

    @Serializable
    object ScreenWorkout : Routes()

    @Serializable
    object ScreenLogin : Routes()

    @Serializable
    object ScreenRegister : Routes()

    @Serializable
    object ScreenMeasurements : Routes()

    @Serializable
    object ScreenExerciseList : Routes()

    @Serializable
    data class ScreenAddEditExercises(
        val exerciseId: Long = -1
    ) : Routes()

    @Serializable
    object ScreenProfile : Routes()

    @Serializable
    object ScreenRoutine : Routes()
}