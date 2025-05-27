package com.uotsoft.hunt.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class NavViewModel: ViewModel() {
    var currentScreen: Screen by mutableStateOf<Screen>(Screen.Home)
        private set

    fun navigateTo(screen: Screen) {
        currentScreen = screen
    }

    fun navigateHome() {
        currentScreen = Screen.Home
    }
}

sealed class Screen {
    object Home : Screen()
    object Kiosk : Screen()
    object Team : Screen()
}