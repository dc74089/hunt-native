package com.uotsoft.hunt

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import com.uotsoft.hunt.ui.screens.HomeScreen
import com.uotsoft.hunt.ui.theme.HuntTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    HuntTheme {
        Navigator(HomeScreen())
    }
}