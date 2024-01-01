package com.imrul.replog.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.imrul.replog.other.Constants.DATABASE_NAME

@Entity(tableName = DATABASE_NAME)
data class WorkoutItem(
    var date: String,
    var weekDay: String,
    var weight: Float,
    var sets: Int,
    var reps: Int,
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null
)