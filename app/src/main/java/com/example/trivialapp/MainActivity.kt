package com.example.trivialapp

import View.GameScreen
import View.LaunchScreen
import View.MenuScreen
import View.ResultScreen
import View.Routes
import View.SettingsScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.trivialapp.ui.theme.TrivialAppTheme
import viewModel.TriviaSettingsViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val settingsViewModel by viewModels<TriviaSettingsViewModel>()
        setContent {
            TrivialAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navigationController = rememberNavController()
                    NavHost(
                        navController = navigationController,
                        startDestination = Routes.LaunchScreen.route
                    ) {
                        composable(Routes.LaunchScreen.route) { LaunchScreen(navigationController) }
                        composable(Routes.MenuScreen.route) { MenuScreen(navigationController, settingsViewModel)}
                        composable(Routes.SettingsScreen.route) { SettingsScreen(navigationController, settingsViewModel) }
                        composable(Routes.GameScreen.route) { GameScreen(navigationController) }
                        composable(Routes.ResultScreen.route) { ResultScreen(navigationController) }
                    }
                }
            }
        }
    }
}

