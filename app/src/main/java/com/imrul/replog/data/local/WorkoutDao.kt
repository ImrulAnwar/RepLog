package com.imrul.replog.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import com.imrul.replog.other.Constants.DATABASE_NAME

@Dao
interface WorkoutDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWorkout(workoutItem: WorkoutItem):Long

    @Delete
    suspend fun deleteWorkout(workoutItem: WorkoutItem)

    @Query("SELECT * FROM $DATABASE_NAME")
    fun observeAllWorkouts(): Flow<List<WorkoutItem>>
}