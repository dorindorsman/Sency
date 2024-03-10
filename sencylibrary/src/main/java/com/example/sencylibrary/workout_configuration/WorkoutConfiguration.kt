package com.example.sencylibrary.workout_configuration

import com.example.sencylibrary.workout_builder.WorkoutBuilder

object WorkoutConfiguration {

    fun configure(workoutSequence: String): WorkoutBuilder {
        val workout = workoutSequence.split('_')
        val type = getType(workout[0])
        val time = workout[1].toLong()
        val reps = workout[2].toInt()
        return WorkoutBuilder(type,time,reps)
    }

    private fun getType(type: String): Exercise {
        return when (type.lowercase()) {
            Exercise.AirSquat.name.lowercase() -> Exercise.AirSquat
            Exercise.JumpingJacks.name.lowercase() -> Exercise.JumpingJacks
            Exercise.Pushups.name.lowercase() -> Exercise.Pushups
            Exercise.Lunges.name.lowercase() -> Exercise.Lunges
            Exercise.Burpees.name.lowercase() -> Exercise.Burpees
            Exercise.Rest.name.lowercase() -> Exercise.Rest
            else -> {
                Exercise.AirSquat
            }
        }
    }

}