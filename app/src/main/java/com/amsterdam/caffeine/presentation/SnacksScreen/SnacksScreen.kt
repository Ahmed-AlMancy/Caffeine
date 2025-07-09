package com.amsterdam.caffeine.presentation.SnacksScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.amsterdam.caffeine.R
import com.amsterdam.caffeine.data.snacks
import com.amsterdam.caffeine.presentation.SnacksScreen.Component.SnackPager
import com.amsterdam.caffeine.presentation.theme.ui.CaffeineBlackColor
import com.amsterdam.caffeine.presentation.theme.ui.CaffeineWhiteColor
import com.amsterdam.caffeine.presentation.theme.ui.urbanist_bold

@Composable
fun SnacksScreen(
    onCloseClick: () -> Unit,
    onSnackClick: (Int) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = CaffeineWhiteColor)
            .padding(top = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .padding(bottom = 24.dp)
                .fillMaxWidth()
                .padding(start = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(color = Color(0xFFF5F5F5))
                    .clickable(onClick = onCloseClick)
            ) {
                Icon(
                    painter = painterResource(R.drawable.cancel_ic),
                    contentDescription = null,
                    tint = CaffeineBlackColor,
                    modifier = Modifier
                        .size(24.dp)
                        .align(Alignment.Center)
                )
            }
        }
        Text(
            text = "Take your snack",
            textAlign = TextAlign.Start,
            fontFamily = urbanist_bold,
            fontSize = 22.sp,
            lineHeight = 26.sp,
            letterSpacing = 0.25.sp,
            color = Color(0xDE1F1F1F),
            modifier = Modifier
                .padding(bottom = 24.dp, start = 16.dp)
                .fillMaxWidth()
        )
        val pagerState = rememberPagerState(pageCount = { snacks.size })
        SnackPager(
            pagerState = pagerState,
            onSnackClick = onSnackClick,
            modifier = Modifier.weight(1f)
        )
    }
}