package com.imrul.replog.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.imrul.replog.other.Constants.DATABASE_NAME
data class BodyWeightWorkout(
    var date: String,
    var weekDay: String,
    var sets: Int,
    var reps: Int,
    @PrimaryKey(autoGenerate = true)
    override var id: Int? = null
) : BaseWorkoutItem()

data class WeightedWorkout(
    var date: String,
    var weekDay: String,
    var weight: Float,
    var sets: Int,
    var reps: Int,
    @PrimaryKey(autoGenerate = true)
    override var id: Int? = null
) : BaseWorkoutItem()

data class CardioWorkout(
    var date: String,
    var weekDay: String,
    var durationMinutes: Int,
    var sets: Int,
    @PrimaryKey(autoGenerate = true)
    override var id: Int? = null
) : BaseWorkoutItem()
