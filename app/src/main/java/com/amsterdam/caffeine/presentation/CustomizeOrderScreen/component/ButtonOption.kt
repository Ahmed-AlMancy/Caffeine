package com.amsterdam.caffeine.presentation.CustomizeOrderScreen.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.amsterdam.caffeine.R
import com.amsterdam.caffeine.presentation.theme.ui.CaffeineWhiteColor

@Composable
fun ButtonOption(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    text: String = "",
    selected: Boolean = false,
    hasIcon: Boolean = false,
) {
    Box(modifier) {
        AnimatedVisibility(
            visible = selected,
            enter = fadeIn(tween(500)),
            exit = fadeOut(tween(1000)),
        ) {
            Box(
                modifier = Modifier
                    .defaultMinSize(
                        minWidth = 40.dp, minHeight = 40.dp
                    )
                    .clip(CircleShape)
                    .background(color = Color(0xFF7C351B))
            ) {
                if (hasIcon) {
                    Icon(
                        painter = painterResource(R.drawable.coffee_beans_ic),
                        contentDescription = null,
                        tint = CaffeineWhiteColor,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
        }
        SizedText(
            text = text,
            onClick = onClick,
            textColor = if (selected) Color.White else Color(0x991F1F1F)
        )
    }
}