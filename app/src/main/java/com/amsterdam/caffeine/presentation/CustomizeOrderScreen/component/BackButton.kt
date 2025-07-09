package com.amsterdam.caffeine.presentation.CustomizeOrderScreen.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.amsterdam.caffeine.R
import com.amsterdam.caffeine.presentation.theme.ui.CaffeineBlackColor
import com.amsterdam.caffeine.presentation.theme.ui.urbanist_bold

@Composable
fun BackButton(
    modifier: Modifier = Modifier,
    title: String,
    onBackClick: () -> Unit
) {
    Row(
        modifier = modifier.padding(start = 16.dp), verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .padding(end = 12.dp)
                .size(48.dp)
                .clip(CircleShape)
                .background(color = Color(0xFFF5F5F5))
                .clickable(onClick = onBackClick)
        ) {
            Icon(
                painter = painterResource(R.drawable.arrow_right_04),
                contentDescription = null,
                tint = CaffeineBlackColor,
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.Center)
            )
        }
        Text(
            text = title,
            textAlign = TextAlign.Start,
            fontFamily = urbanist_bold,
            fontWeight = FontWeight.W700,
            fontSize = 24.sp,
            lineHeight = 26.sp,
            letterSpacing = 0.25.sp,
            color = CaffeineBlackColor
        )
    }
}