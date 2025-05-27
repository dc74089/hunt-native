package com.uotsoft.hunt.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uotsoft.hunt.net.pollServerForKiosk
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class KioskViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(KioskUiState())
    val uiState: StateFlow<KioskUiState> = _uiState

    private fun startPolling() {
        viewModelScope.launch {
            while (true) {
                val result = pollServerForKiosk()
                _uiState.value = result
                delay(1000)
            }
        }
    }
}

data class KioskUiState (
    val state: KioskState = KioskState.Message,
    val message: String = "",
    val question: String = "",
    val teamName: String = "",
)

sealed class KioskState {
    object Scan: KioskState()
    object Message: KioskState()
    object Question: KioskState()
}