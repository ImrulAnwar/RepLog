package com.imrul.replog.repository

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.imrul.replog.data.local.BaseWorkoutItem
import kotlinx.coroutines.flow.Flow

interface WorkoutRepository {

    suspend fun insertWorkout(workoutItem: BaseWorkoutItem)

    suspend fun deleteWorkout(workoutItem: BaseWorkoutItem)

    fun observeAllWorkouts(): Flow<List<BaseWorkoutItem>>
}