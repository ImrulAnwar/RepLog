package com.imrul.replog.repository

import com.imrul.replog.data.local.WorkoutItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class FakeWorkoutRepository :WorkoutRepository{
    private val workoutItems = mutableListOf<WorkoutItem>()
    private val observableWorkoutItems = MutableStateFlow<List<WorkoutItem>>(workoutItems)

    override suspend fun insertWorkout(workoutItem: WorkoutItem) {
        workoutItems.add(workoutItem)
        observableWorkoutItems.value = workoutItems.toList()
    }

    override suspend fun deleteWorkout(workoutItem: WorkoutItem) {
        workoutItems.remove(workoutItem)
        observableWorkoutItems.value = workoutItems.toList()
    }

    override fun observeAllWorkouts(): Flow<List<WorkoutItem>> {
        return observableWorkoutItems
    }

}