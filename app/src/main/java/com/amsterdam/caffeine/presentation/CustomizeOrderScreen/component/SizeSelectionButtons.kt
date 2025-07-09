package com.amsterdam.caffeine.presentation.CustomizeOrderScreen.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.amsterdam.caffeine.presentation.CustomizeOrderScreen.viewmodel.CupSize
import com.amsterdam.caffeine.presentation.CustomizeOrderScreen.viewmodel.CustomizeOrderUiState

@Composable
fun SizeSelectionButtons(
    uiState: CustomizeOrderUiState,
    updateCupSize: (CupSize) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .defaultMinSize(
                minWidth = 152.dp, minHeight = 56.dp
            )
            .background(color = Color(0xFFF5F5F5), shape = CircleShape)
            .padding(8.dp)
    ) {
        ButtonOption(
            onClick = {
                updateCupSize(CupSize.SMALL)
            },
            text = "S",
            modifier = Modifier.align(Alignment.CenterStart),
            selected = uiState.cupSize == CupSize.SMALL,
        )
        ButtonOption(
            onClick = {
                updateCupSize(CupSize.MEDIUM)
            },
            text = "M",
            selected = uiState.cupSize == CupSize.MEDIUM,
            modifier = Modifier.align(Alignment.Center)
        )
        ButtonOption(
            onClick = {
                updateCupSize(CupSize.LARGE)
            },
            text = "L",
            selected = uiState.cupSize == CupSize.LARGE,
            modifier = Modifier.align(Alignment.CenterEnd)
        )
    }
}