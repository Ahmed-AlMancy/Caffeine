package com.amsterdam.caffeine.presentation.CustomizeOrderScreen.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.amsterdam.caffeine.presentation.theme.ui.urbanist_bold

@Composable
fun SizedText(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    textColor: Color = Color(0x991F1F1F)
) {
    Box(
        modifier = modifier
            .defaultMinSize(
                minWidth = 40.dp, minHeight = 40.dp
            )
            .clickable(
                onClick = onClick,
                indication = null,
                interactionSource = remember { MutableInteractionSource() })
    ) {
        Text(
            text = text,
            fontFamily = urbanist_bold,
            fontSize = 20.sp,
            lineHeight = 24.sp,
            letterSpacing = 0.25.sp,
            color = textColor,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}