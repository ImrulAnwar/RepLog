package com.imrul.replog.data.repository

import com.imrul.replog.data.local.WorkoutItem
import com.imrul.replog.data.repository.WorkoutRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class FakeWorkoutRepository : WorkoutRepository {
    private val workoutItems = mutableListOf<WorkoutItem>()
    private val observableWorkoutItems = MutableStateFlow<List<WorkoutItem>>(workoutItems)

    override suspend fun insertWorkout(workoutItem: WorkoutItem): Long? {
        workoutItems.add(workoutItem)
        observableWorkoutItems.value = workoutItems.toList()
        return workoutItem.id?.toLong()
    }

    override suspend fun deleteWorkout(workoutItem: WorkoutItem) {
        workoutItems.remove(workoutItem)
        observableWorkoutItems.value = workoutItems.toList()
    }

    override fun observeAllWorkouts(): Flow<List<WorkoutItem>> {
        return observableWorkoutItems
    }

}