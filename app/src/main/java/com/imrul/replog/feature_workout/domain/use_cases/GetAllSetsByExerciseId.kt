package com.imrul.replog.feature_workout.domain.use_cases

import com.imrul.replog.feature_workout.domain.repository.WorkoutRepository

class GetAllSetsByExerciseId(
    private val repository: WorkoutRepository
) {
    operator fun invoke(exerciseId: Long) = repository.getAllSetsByExerciseId(exerciseId)
}