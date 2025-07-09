package com.amsterdam.caffeine.presentation.HomeScreen.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.amsterdam.caffeine.R
import com.amsterdam.caffeine.presentation.theme.ui.CaffeineBlackColor
import com.amsterdam.caffeine.presentation.theme.ui.sniglet_normal

@Composable
fun HocusPocusSection(
    modifier: Modifier = Modifier, alpha: Float = 0.0f
) {
    Box(
        modifier = modifier
    ) {
        Text(
            text = "Hocus\nPocus\nI Need Coffee\nto Focus",
            textAlign = TextAlign.Center,
            fontFamily = sniglet_normal,
            fontWeight = FontWeight.W400,
            fontSize = 32.sp,
            lineHeight = 50.sp,
            letterSpacing = 0.25.sp,
            color = Color(0xDE1F1F1F),
        )
        Icon(
            painter = painterResource(R.drawable.star_caffeine),
            contentDescription = null,
            tint = CaffeineBlackColor,
            modifier = Modifier
                .size(16.dp)
                .align(Alignment.BottomEnd)
                .offset(x = (20).dp)
                .alpha(alpha)

        )
        Icon(
            painter = painterResource(R.drawable.star_caffeine),
            contentDescription = null,
            tint = CaffeineBlackColor,
            modifier = Modifier
                .size(16.dp)
                .align(Alignment.TopEnd)
                .alpha(alpha)

        )
        Icon(
            painter = painterResource(R.drawable.star_caffeine),
            contentDescription = null,
            tint = CaffeineBlackColor,
            modifier = Modifier
                .size(16.dp)
                .align(Alignment.CenterStart)
                .offset(y = (-30).dp)
                .alpha(alpha)


        )
    }
}