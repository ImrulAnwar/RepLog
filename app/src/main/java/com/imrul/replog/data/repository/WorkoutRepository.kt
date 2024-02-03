package com.imrul.replog.data.repository

import com.imrul.replog.data.local.WorkoutItem
import kotlinx.coroutines.flow.Flow

interface WorkoutRepository {

    suspend fun insertWorkout(workoutItem: WorkoutItem):Long?

    suspend fun deleteWorkout(workoutItem: WorkoutItem)

    fun observeAllWorkouts(): Flow<List<WorkoutItem>>
}