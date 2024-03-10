package com.example.sencylibrary

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

object Route {
    const val Workout = "Workout"
}

@Composable
fun WorkoutMainNavigation(
    modifier: Modifier = Modifier, navController: NavHostController,
) {
    val appContext = LocalContext.current.applicationContext
    NavHost(
        navController = navController,
        startDestination = Route.Workout
    ) {
        composable(Route.Workout) {
           WorkoutScreen(viewModel = WorkoutViewModel())
        }

    }
}
