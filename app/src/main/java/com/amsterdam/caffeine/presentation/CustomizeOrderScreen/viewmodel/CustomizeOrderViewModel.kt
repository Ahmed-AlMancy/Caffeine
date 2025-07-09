package com.amsterdam.caffeine.presentation.CustomizeOrderScreen.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CustomizeOrderViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(CustomizeOrderUiState())
    val uiState = _uiState.asStateFlow()

    fun updateCupSize(cupSize: CupSize) {
        _uiState.value = _uiState.value.copy(cupSize = cupSize)
    }

    fun updateCaffeineDose(caffeineDose: CaffeineDose) {
        _uiState.value = _uiState.value.copy(caffeineDose = caffeineDose)
    }

    fun hideTopBar() {
        _uiState.value = _uiState.value.copy(isTopBarVisible = !_uiState.value.isTopBarVisible)
    }
}