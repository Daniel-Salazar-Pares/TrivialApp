package com.example.trivialapp

sealed class Routes(val route: String) {
    object LaunchScreen:Routes("LaunchScreen")
    object MenuScreen:Routes("MenuScreen")
    object SettingsScreen:Routes("SettingsScreen")
    object GameScreen:Routes("GameScreen")
    object ResultScreen:Routes("ResultScreen")
}
