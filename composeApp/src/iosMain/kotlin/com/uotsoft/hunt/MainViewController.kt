package com.uotsoft.hunt

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.window.ComposeUIViewController

fun MainViewController() = ComposeUIViewController {
    App()

    LaunchedEffect(Unit) {
        // TODO: Add status bar call to Swift function
    }
}