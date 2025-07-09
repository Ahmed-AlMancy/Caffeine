package com.amsterdam.caffeine.presentation.HomeScreen

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.amsterdam.caffeine.R
import com.amsterdam.caffeine.presentation.HomeScreen.component.HocusPocusSection
import com.amsterdam.caffeine.presentation.shared.TopAppBar
import com.amsterdam.caffeine.presentation.theme.ui.CaffeineBlackColor
import com.amsterdam.caffeine.presentation.theme.ui.CaffeineWhiteColor
import com.amsterdam.caffeine.presentation.theme.ui.sniglet_normal

@Composable
fun HomeScreen(
    onButtonClick: () -> Unit
) {

    val infiniteTransition = rememberInfiniteTransition()
    val alpha = infiniteTransition.animateFloat(
        initialValue = 0.2f, targetValue = 1f, label = "", animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 600
            ), repeatMode = RepeatMode.Reverse
        )
    )
    val offset = infiniteTransition.animateFloat(
        initialValue = 0f, targetValue = 20f, label = "", animationSpec = infiniteRepeatable(
            animation = tween(1700), repeatMode = RepeatMode.Reverse
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = CaffeineWhiteColor)
            .verticalScroll(
                state = rememberScrollState(), enabled = true
            )
            .padding(vertical = 16.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopAppBar(
            Modifier.padding(bottom = 24.dp)
        )
        HocusPocusSection(
            modifier = Modifier
                .defaultMinSize(minHeight = 200.dp, minWidth = 188.dp)
                .align(Alignment.CenterHorizontally),
            alpha = alpha.value
        )
        Image(
            painter = painterResource(R.drawable.ghost_caffeine),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 16.dp)
                .size(244.dp)
                .align(Alignment.CenterHorizontally)
                .offset(y = offset.value.dp)
        )
        Box(
            modifier = Modifier
                .width((178 - offset.value).dp)
                .height(28.dp)
                .offset(y = -(offset.value - 20).dp)

        )
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = onButtonClick,
            modifier = Modifier
                .defaultMinSize(minHeight = 56.dp)
                .padding(horizontal = 32.dp, vertical = 18.dp)
                .background(
                    color = CaffeineBlackColor, shape = CircleShape
                )
                .shadow(
                    elevation = 5.dp,
                    spotColor = CaffeineBlackColor,
                    ambientColor = CaffeineBlackColor,
                    shape = CircleShape
                ),
            colors = ButtonColors(
                containerColor = CaffeineBlackColor,
                contentColor = CaffeineWhiteColor,
                disabledContainerColor = CaffeineWhiteColor,
                disabledContentColor = CaffeineBlackColor
            )
        ) {
            Text(
                text = "bring my coffee",
                textAlign = TextAlign.Start,
                fontFamily = sniglet_normal,
                fontWeight = FontWeight.W700,
                fontSize = 16.sp,
                lineHeight = 18.sp,
                letterSpacing = 0.25.sp,
            )
            Icon(
                painter = painterResource(R.drawable.coffee_cup_ic),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 8.dp)
                    .size(24.dp)
            )
        }
    }

}