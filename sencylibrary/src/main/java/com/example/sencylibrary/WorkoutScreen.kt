package com.example.sencylibrary

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import java.util.concurrent.TimeUnit

@Composable
fun WorkoutScreen(
    viewModel: WorkoutViewModel
) {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
    ) {

        val (
            camera,
            content
        ) = createRefs()

        WorkoutCamera(
            Modifier
                .constrainAs(camera) {
                    linkTo(
                        start = parent.start,
                        end = parent.end,
                    )
                    top.linkTo(parent.top)
                },
        )
        WorkoutContent(
            modifier = Modifier
                .constrainAs(content) {
                    linkTo(
                        start = parent.start,
                        end = parent.end
                    )
                    bottom.linkTo(parent.bottom, 12.dp)
                },
            viewModel = viewModel
        )
    }
}


@Composable
fun WorkoutCamera(modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.Black)
    )
    {}
}

@Composable
fun WorkoutContent(modifier: Modifier, viewModel: WorkoutViewModel) {
    if (viewModel.isRunning) {
        showTimer(modifier, viewModel)
    } else {
        showWorkoutVideo(modifier)
    }

}

@Composable
fun showTimer(modifier: Modifier, viewModel: WorkoutViewModel) {

    val context = LocalContext.current

    val keyboardControllers = LocalSoftwareKeyboardController.current

    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    )
    {
        Text(
            text = formatTime(timeMi = viewModel.time),
            color = Color.White,
            style = MaterialTheme.typography.h3,
            modifier = Modifier.padding(8.dp)
        )
    }

    LaunchedEffect(viewModel.isRunning){
        viewModel.startTimer()
    }
}

@Composable
fun formatTime(timeMi: Long): String {
    val min = TimeUnit.MILLISECONDS.toMinutes(timeMi)
    val sec = TimeUnit.MILLISECONDS.toSeconds(timeMi)
    return String.format("%02d:%02d", min, sec)
}

@Composable
fun showWorkoutVideo(modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.Black)
    )
    {}
}
