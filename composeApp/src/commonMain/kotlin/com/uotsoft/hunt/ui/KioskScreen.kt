package com.uotsoft.hunt.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.uotsoft.hunt.viewmodels.KioskViewModel
import com.uotsoft.hunt.viewmodels.NavViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun KioskScreen(navViewModel: NavViewModel, kioskViewModel: KioskViewModel = KioskViewModel()) {
    Column {
        Text("Hello World!")
    }
}