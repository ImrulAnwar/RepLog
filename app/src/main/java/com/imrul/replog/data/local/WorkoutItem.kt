package com.imrul.replog.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "workout_database")
data class WorkoutItem(
    var date: String,
    var weekDay: String,
    var weight: Float,
    var sets: Int,
    var reps: Int,
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null
)