package com.imrul.replog.data.local
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.imrul.replog.other.Constants

@Entity(tableName = Constants.DATABASE_NAME)
open class WorkoutItem {
    @PrimaryKey(autoGenerate = true)
    open var id: Int? = null
}
data class BodyWeightWorkout(
    var date: String,
    var weekDay: String,
    var sets: Int,
    var reps: Int,
    @PrimaryKey(autoGenerate = true)
    override var id: Int? = null
) : WorkoutItem()

data class WeightedWorkout(
    var date: String,
    var weekDay: String,
    var weight: Float,
    var sets: Int,
    var reps: Int,
    @PrimaryKey(autoGenerate = true)
    override var id: Int? = null
) : WorkoutItem()

data class CardioWorkout(
    var date: String,
    var weekDay: String,
    var durationMinutes: Int,
    var sets: Int,
    @PrimaryKey(autoGenerate = true)
    override var id: Int? = null
) : WorkoutItem()
