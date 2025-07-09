package com.amsterdam.caffeine.presentation.CustomizeOrderScreen.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.amsterdam.caffeine.presentation.CustomizeOrderScreen.viewmodel.CaffeineDose
import com.amsterdam.caffeine.presentation.CustomizeOrderScreen.viewmodel.CustomizeOrderUiState
import com.amsterdam.caffeine.presentation.theme.ui.urbanist_bold

@Composable
fun DoseSelectionButtons(
    uiState: CustomizeOrderUiState,
    updateSelectedCaffeineSize: (CaffeineDose) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .padding(top = 16.dp)
            .defaultMinSize(
                minWidth = 152.dp, minHeight = 56.dp
            )
            .background(color = Color(0xFFF5F5F5), shape = CircleShape)
            .padding(8.dp)
    ) {
        ButtonOption(
            onClick = {
                updateSelectedCaffeineSize(CaffeineDose.LOW)
            },
            text = "",
            modifier = Modifier.align(Alignment.CenterStart),
            selected = uiState.caffeineDose == CaffeineDose.LOW,
            hasIcon = true
        )
        ButtonOption(
            onClick = {
                updateSelectedCaffeineSize(CaffeineDose.MEDIUM)
            },
            text = "",
            selected = uiState.caffeineDose == CaffeineDose.MEDIUM,
            modifier = Modifier.align(Alignment.Center),
            hasIcon = true
        )
        ButtonOption(
            onClick = {
                updateSelectedCaffeineSize(CaffeineDose.HIGH)
            },
            text = "",
            selected = uiState.caffeineDose == CaffeineDose.HIGH,
            modifier = Modifier.align(Alignment.CenterEnd),
            hasIcon = true
        )
    }
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(top = 2.dp)
            .width(152.dp)
    ) {
        Text(
            text = "Low",
            fontFamily = urbanist_bold,
            fontSize = 10.sp,
            lineHeight = 14.sp,
            letterSpacing = 0.25.sp,
            color = Color(0x991F1F1F),
        )
        Text(
            text = "Medium",
            fontFamily = urbanist_bold,
            fontSize = 10.sp,
            lineHeight = 14.sp,
            letterSpacing = 0.25.sp,
            color = Color(0x991F1F1F),
        )
        Text(
            text = "High",
            fontFamily = urbanist_bold,
            fontSize = 10.sp,
            lineHeight = 14.sp,
            letterSpacing = 0.25.sp,
            color = Color(0x991F1F1F),
        )
    }
}