package com.imrul.replog.core

import kotlinx.serialization.Serializable

open class Routes {
    @Serializable
    object ScreenWorkoutHistory : Routes()

    @Serializable
    object ScreenWorkout : Routes()

    @Serializable
    object ScreenLogin : Routes()

    @Serializable
    object ScreenRegister : Routes()
}