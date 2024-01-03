package com.imrul.replog.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface WorkoutDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWorkout(workoutItem: WorkoutItem)

    @Delete
    suspend fun deleteWorkout(workoutItem: WorkoutItem)

    @Query("SELECT * FROM workout_database")
    fun observeAllWorkouts(): Flow<List<WorkoutItem>>
}