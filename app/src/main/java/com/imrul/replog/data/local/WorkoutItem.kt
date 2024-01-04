package com.imrul.replog.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.imrul.replog.other.Constants.DATABASE_NAME

@Entity(tableName = DATABASE_NAME)
data class WorkoutItem(
    var date: String,
    var weekDay: String,
    var type: WorkoutType,
    var sets: Int,
    var reps: Int?=null,
    var weight: Float? = null,
    var durationMinutes: Int? = null,
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
)

enum class WorkoutType {
    BODY_WEIGHT,
    WEIGHTED,
    CARDIO
}
