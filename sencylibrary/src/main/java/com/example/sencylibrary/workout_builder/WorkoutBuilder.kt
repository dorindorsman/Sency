package com.example.sencylibrary.workout_builder

import com.example.sencylibrary.workout_configuration.Exercise

data class WorkoutBuilder(override val type: Exercise, override val time: Long, override val repsNumber: Int) : Builder
