package com.amsterdam.caffeine.presentation.CustomizeOrderScreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.amsterdam.caffeine.presentation.CustomizeOrderScreen.viewmodel.CustomizeOrderViewModel

@Composable
fun CustomizeOrderScreen(
    coffeeTypeTitle: String,
    onBackClick: () -> Unit,
    viewModel: CustomizeOrderViewModel,
    onContinueClick: (Int) -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()
    CustomizeOrderScreenContent(
        coffeeTypeTitle,
        onBackClick,
        uiState,
        viewModel::updateCupSize,
        viewModel::updateCaffeineDose,
        viewModel::hideTopBar,
        onContinueClick
    )
}