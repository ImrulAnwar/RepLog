package com.imrul.replog.repository

import com.imrul.replog.data.local.BaseWorkoutItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class FakeWorkoutRepository :WorkoutRepository{
    private val workoutItems = mutableListOf<BaseWorkoutItem>()
    private val observableWorkoutItems = MutableStateFlow<List<BaseWorkoutItem>>(workoutItems)

    override suspend fun insertWorkout(workoutItem: BaseWorkoutItem) {
        workoutItems.add(workoutItem)
        observableWorkoutItems.value = workoutItems.toList()
    }

    override suspend fun deleteWorkout(workoutItem: BaseWorkoutItem) {
        workoutItems.remove(workoutItem)
        observableWorkoutItems.value = workoutItems.toList()
    }

    override fun observeAllWorkouts(): Flow<List<BaseWorkoutItem>> {
        return observableWorkoutItems
    }

}