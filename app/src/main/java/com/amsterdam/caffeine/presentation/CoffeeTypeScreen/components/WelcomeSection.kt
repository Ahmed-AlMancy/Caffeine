package com.amsterdam.caffeine.presentation.CoffeeTypeScreen.components


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.amsterdam.caffeine.presentation.theme.ui.urbanist_bold

@Composable
fun WelcomeSection() {
    Column {
        Text(
            text = "Good Morning",
            textAlign = TextAlign.Start,
            fontFamily = urbanist_bold,
            fontSize = 36.sp,
            lineHeight = 40.sp,
            letterSpacing = 0.25.sp,
            color = Color(0xFFB3B3B3),
            modifier = Modifier.padding(start = 16.dp)
        )
        Text(
            text = "Almancy ☀",
            textAlign = TextAlign.Start,
            fontFamily = urbanist_bold,
            fontSize = 36.sp,
            lineHeight = 40.sp,
            letterSpacing = 0.25.sp,
            color = Color(0xFF3B3B3B),
            modifier = Modifier.padding(start = 16.dp)
        )
        Text(
            text = "What would you like to drink today?",
            textAlign = TextAlign.Start,
            fontFamily = urbanist_bold,
            fontSize = 16.sp,
            lineHeight = 18.sp,
            letterSpacing = 0.25.sp,
            color = Color(0xCC1F1F1F),
            modifier = Modifier.padding(start = 16.dp, bottom = 36.dp)
        )
    }
}