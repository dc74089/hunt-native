package com.uotsoft.hunt

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import com.uotsoft.hunt.ui.HomeScreen
import com.uotsoft.hunt.ui.KioskScreen
import com.uotsoft.hunt.ui.TeamScreen
import com.uotsoft.hunt.viewmodels.NavViewModel
import com.uotsoft.hunt.viewmodels.Screen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(navViewModel: NavViewModel = remember { NavViewModel() }) {
    MaterialTheme {
        when (navViewModel.currentScreen) {
            Screen.Home -> HomeScreen(navViewModel)
            Screen.Kiosk -> KioskScreen(navViewModel)
            Screen.Team -> TeamScreen(navViewModel)
        }
    }
}