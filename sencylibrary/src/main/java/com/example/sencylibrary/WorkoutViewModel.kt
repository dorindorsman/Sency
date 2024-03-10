package com.example.sencylibrary

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class WorkoutViewModel(
) : ViewModel() {

    companion object {
        const val TAG = "WorkoutViewModel"
    }

    var isRunning by mutableStateOf(true)

    var time by mutableLongStateOf(0L)

    var startTime by mutableLongStateOf(0L)


    fun startTimer(){
        viewModelScope.launch {
            while (isRunning){
                delay(1000)
                time = System.currentTimeMillis() - startTime
            }
        }
    }

}