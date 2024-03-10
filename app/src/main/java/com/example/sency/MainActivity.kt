package com.example.sency

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.sency.ui.theme.SencyTheme
import com.example.sencylibrary.WorkoutMainNavigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SencyTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    WorkoutMainNavigation(modifier = Modifier.fillMaxSize(), navController = navController)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SencyTheme {
    }
}