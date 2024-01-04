package com.imrul.replog.data.local

import android.annotation.SuppressLint
import android.util.Log
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest

class WorkoutDaoTest {

    //to make sure they run sequentially
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: WorkoutDatabase
    private lateinit var dao: WorkoutDao

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            WorkoutDatabase::class.java
        ).allowMainThreadQueries().build()
        dao = database.workoutDao()
    }

    @After
    fun teardown() {
        database.close()
    }

    @SuppressLint("CheckResult")
    @Test
    fun insertWorkoutTest() = runTest {
        val workoutItem1 = WorkoutItem(date = "2024-01-04", weekDay = "Monday", type = WorkoutType.BODY_WEIGHT, sets = 3, reps = 12)
        val workoutItem2 = WorkoutItem(date = "2024-01-04", weekDay = "Tuesday", type = WorkoutType.WEIGHTED, sets = 4, reps = 10, weight = 50.0f)
        val workoutItem3 = WorkoutItem(date = "2024-01-04", weekDay = "Wednesday", type = WorkoutType.CARDIO, sets = 1, durationMinutes = 30)
        dao.insertWorkout(workoutItem1)
        dao.insertWorkout(workoutItem2)
        dao.insertWorkout(workoutItem3)
        var allWorkouts: List<WorkoutItem>? = null

        // Launch a coroutine job and store the reference to it
        val job = launch {
            dao.observeAllWorkouts().collect {
                allWorkouts = it
            }
        }
        testScheduler.apply { runCurrent() } // Adjust the time as needed
        job.cancelAndJoin()
        Truth.assertThat(allWorkouts?.contains(workoutItem1))
        Truth.assertThat(allWorkouts?.contains(workoutItem2))
        Truth.assertThat(allWorkouts?.contains(workoutItem3))
    }

    @Test
    fun deleteWorkoutTest() = runTest {
        val workoutItem1 = WorkoutItem(date = "2024-01-04", weekDay = "Monday", type = WorkoutType.BODY_WEIGHT, sets = 3, reps = 12)
        val workoutItem2 = WorkoutItem(date = "2024-01-04", weekDay = "Tuesday", type = WorkoutType.WEIGHTED, sets = 4, reps = 10, weight = 50.0f)
        val workoutItem3 = WorkoutItem(date = "2024-01-04", weekDay = "Wednesday", type = WorkoutType.CARDIO, sets = 1, durationMinutes = 30)

        // Insert workouts and get the generated IDs
        val id1 = dao.insertWorkout(workoutItem1).toInt()
        val id2 = dao.insertWorkout(workoutItem2).toInt()
        val id3 = dao.insertWorkout(workoutItem3).toInt()

        // Set the generated IDs to the workout items
        workoutItem1.id = id1
        workoutItem2.id = id2
        workoutItem3.id = id3

        dao.insertWorkout(workoutItem1)
        dao.insertWorkout(workoutItem2)
        dao.insertWorkout(workoutItem3)
        dao.deleteWorkout(workoutItem1)
        dao.deleteWorkout(workoutItem2)
        dao.deleteWorkout(workoutItem3)

        var allWorkouts: List<WorkoutItem>? = null
        val job = launch {
            dao.observeAllWorkouts().collect {
                allWorkouts = it
            }
        }

        testScheduler.apply { runCurrent() }
        job.cancelAndJoin()


        if (allWorkouts == null) {
            Log.d("TestLog", "allWorkouts is null")
        } else {
            Log.d("TestLog", "allWorkouts: $allWorkouts")
        }
        Truth.assertThat(allWorkouts).isEmpty()
    }

}