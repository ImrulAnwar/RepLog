package com.imrul.replog.data.local

import android.annotation.SuppressLint
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject
import javax.inject.Named

@SmallTest
@HiltAndroidTest

class WorkoutDaoTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    //to make sure they run sequentially
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Inject
    @Named("test_db")
    lateinit var database: WorkoutDatabase
    private lateinit var dao: WorkoutDao

    @Before
    fun setup() {
        hiltRule.inject()
        dao = database.workoutDao()
    }

    @After
    fun teardown() {
        database.close()
    }

    @SuppressLint("CheckResult")
    @Test
    fun insertWorkoutTest() = runTest {
        val workoutItem1 =WeightedWorkout("2023-12-27", "Wednesday", 25f, 2, reps = 12)
        val workoutItem2 =BodyWeightWorkout("2023-12-27", "Wednesday", 2, 2)
        val workoutItem3 =CardioWorkout("2023-12-27", "Wednesday", 40, 2)
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
        val workoutItem1 =WeightedWorkout("2023-12-27", "Wednesday", 25f, 2, reps = 12)
        val workoutItem2 =BodyWeightWorkout("2023-12-27", "Wednesday", 2, 2)
        val workoutItem3 =CardioWorkout("2023-12-27", "Wednesday", 40, 2)

        workoutItem1.id = dao.insertWorkout(workoutItem1)?.toInt()
        workoutItem2.id = dao.insertWorkout(workoutItem2)?.toInt()
        workoutItem3.id = dao.insertWorkout(workoutItem3)?.toInt()

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

        Truth.assertThat(allWorkouts).isEmpty()
    }

}