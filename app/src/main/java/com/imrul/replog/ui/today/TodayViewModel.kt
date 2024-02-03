package com.imrul.replog.ui.today

import androidx.lifecycle.ViewModel
import com.imrul.replog.data.repository.WorkoutRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TodayViewModel @Inject constructor(
    private val repository: WorkoutRepository
): ViewModel(){

}