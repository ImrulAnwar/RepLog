package com.imrul.replog.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.imrul.replog.other.Constants.DATABASE_NAME


@Entity(tableName = DATABASE_NAME)
open class BaseWorkoutItem {
    @PrimaryKey(autoGenerate = true)
    open var id: Int? = null
}