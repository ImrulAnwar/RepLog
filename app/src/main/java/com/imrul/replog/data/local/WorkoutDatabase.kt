package com.imrul.replog.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [BaseWorkoutItem::class],
    version = 1
)
abstract class WorkoutDatabase: RoomDatabase(){
    abstract fun workoutDao():WorkoutDao
}