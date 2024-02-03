package com.imrul.replog.di

import android.content.Context
import androidx.room.Room
import com.imrul.replog.data.local.WorkoutDao
import com.imrul.replog.data.local.WorkoutDatabase
import com.imrul.replog.other.Constants.DATABASE_NAME
import com.imrul.replog.data.repository.DefaultWorkoutRepository
import com.imrul.replog.data.repository.WorkoutRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideWorkoutDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(context, WorkoutDatabase::class.java, DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideWorkoutDao(
        database: WorkoutDatabase
    ) = database.workoutDao()

    @Singleton
    @Provides
    fun provideDefaultShoppingRepository(
        dao: WorkoutDao
    ) = DefaultWorkoutRepository(dao) as WorkoutRepository
}