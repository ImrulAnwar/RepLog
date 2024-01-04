package com.imrul.replog.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [WorkoutItem::class],
    version = 2
)

abstract class WorkoutDatabase: RoomDatabase(){
    abstract fun workoutDao():WorkoutDao
}
