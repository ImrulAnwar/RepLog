package com.imrul.replog.repository

import com.imrul.replog.data.local.WorkoutItem
import com.imrul.replog.data.local.WorkoutDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DefaultWorkoutRepository @Inject constructor(
    private val workoutDao: WorkoutDao
) : WorkoutRepository {
    override suspend fun insertWorkout(workoutItem: WorkoutItem) {
        workoutDao.insertWorkout(workoutItem)
    }

    override suspend fun deleteWorkout(workoutItem: WorkoutItem) {
        workoutDao.deleteWorkout(workoutItem)
    }

    override fun observeAllWorkouts(): Flow<List<WorkoutItem>> {
        return workoutDao.observeAllWorkouts()
    }
}