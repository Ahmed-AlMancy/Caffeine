package com.amsterdam.caffeine.presentation.CoffeeTypeScreen.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import androidx.compose.ui.unit.sp
import com.amsterdam.caffeine.data.CoffeeType
import com.amsterdam.caffeine.presentation.theme.ui.urbanist_bold
import kotlin.math.absoluteValue

@Composable
fun CoffeeTypePager(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    coffeeTypes: List<CoffeeType>,
) {
    HorizontalPager(
        state = pagerState,
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 100.dp)
    ) { pageIndex ->
        val coffeeType = coffeeTypes[pageIndex]
        val progress =
            1f - pagerState.getOffsetDistanceInPages(pageIndex).absoluteValue.coerceIn(0f, 1f)
        val imageWidth by animateDpAsState(
            targetValue = lerp(120.dp, 200.dp, progress), label = ""
        )
        val imageHeight by animateDpAsState(
            targetValue = lerp(150.dp, 244.dp, progress), label = ""
        )
        Column(
            modifier = Modifier
                .defaultMinSize(minHeight = 298.dp)
                .width(199.dp)
                .offset(y = (progress * -3).dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(coffeeType.image),
                contentDescription = null,
                modifier = Modifier.size(
                    width = imageWidth, height = imageHeight
                )
            )
            Text(
                text = coffeeType.name,
                textAlign = TextAlign.Center,
                fontFamily = urbanist_bold,
                fontSize = 32.sp,
                lineHeight = 35.sp,
                letterSpacing = 0.25.sp,
                color = Color(0xFF1F1F1F),
                modifier = Modifier.padding(top = 16.dp)
            )

        }
    }
}