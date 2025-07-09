package com.amsterdam.caffeine.presentation.CustomizeOrderScreen.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.amsterdam.caffeine.R
import com.amsterdam.caffeine.presentation.CustomizeOrderScreen.viewmodel.CustomizeOrderUiState
import com.amsterdam.caffeine.presentation.theme.ui.urbanist_bold

@Composable
fun CupAnimation(
    uiState: CustomizeOrderUiState,
    coffeeSize: Dp,
    coffeeOffsetAnimation: Float,
    cupHeight: Dp,
    cupWidth: Dp,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .height(342.dp)
            .padding(horizontal = 16.dp)
            .padding(top = 16.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = uiState.cupSize.size.toString() + " ML",
            textAlign = TextAlign.Start,
            fontFamily = urbanist_bold,
            fontSize = 14.sp,
            lineHeight = 18.sp,
            letterSpacing = 0.25.sp,
            color = Color(0x99000000),
            modifier = Modifier.padding(top = 64.dp, end = 16.dp)
        )
        Image(
            painter = painterResource(R.drawable.coffee),
            contentDescription = null,
            modifier = Modifier
                .size(coffeeSize)
                .align(Alignment.TopCenter)
                .offset(y = coffeeOffsetAnimation.dp)

        )
        Box(
            modifier = Modifier
                .size(cupWidth, cupHeight)
                .align(Alignment.Center)
        ) {
            Image(
                painter = painterResource(R.drawable.empty_cup),
                contentDescription = null,
                modifier = Modifier
                    .size(cupWidth, cupHeight)
                    .align(Alignment.Center)
            )
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(cupWidth * 0.3f)
            )
        }
    }
}