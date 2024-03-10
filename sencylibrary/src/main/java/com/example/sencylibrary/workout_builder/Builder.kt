package com.example.sencylibrary.workout_builder

import com.example.sencylibrary.workout_configuration.Exercise


interface Builder {
    val type: Exercise

    val time: Long

    val repsNumber: Int
}

