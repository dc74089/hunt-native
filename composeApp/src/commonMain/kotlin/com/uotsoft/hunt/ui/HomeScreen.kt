package com.uotsoft.hunt.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.uotsoft.hunt.viewmodels.NavViewModel
import com.uotsoft.hunt.viewmodels.Screen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun HomeScreen(navViewModel: NavViewModel? = null) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterVertically)
    ) {
        Button(onClick = { navViewModel?.navigateTo(Screen.Kiosk) }) {
            Text("Kiosk")
        }
        Button(onClick = { navViewModel?.navigateTo(Screen.Team) }) {
            Text("Team")
        }
    }
}