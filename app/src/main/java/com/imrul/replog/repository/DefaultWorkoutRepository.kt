package com.imrul.replog.repository

import com.imrul.replog.data.local.BaseWorkoutItem
import com.imrul.replog.data.local.WorkoutDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DefaultWorkoutRepository @Inject constructor(
    private val workoutDao: WorkoutDao
) : WorkoutRepository {
    override suspend fun insertWorkout(workoutItem: BaseWorkoutItem) {
        workoutDao.insertWorkout(workoutItem)
    }

    override suspend fun deleteWorkout(workoutItem: BaseWorkoutItem) {
        workoutDao.deleteWorkout(workoutItem)
    }

    override fun observeAllWorkouts(): Flow<List<BaseWorkoutItem>> {
        return workoutDao.observeAllWorkouts()
    }
}