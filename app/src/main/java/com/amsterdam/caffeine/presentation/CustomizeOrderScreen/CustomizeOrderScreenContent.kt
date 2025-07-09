package com.amsterdam.caffeine.presentation.CustomizeOrderScreen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.amsterdam.caffeine.presentation.CustomizeOrderScreen.component.BackButton
import com.amsterdam.caffeine.presentation.CustomizeOrderScreen.component.ContinueButton
import com.amsterdam.caffeine.presentation.CustomizeOrderScreen.component.CupAnimation
import com.amsterdam.caffeine.presentation.CustomizeOrderScreen.component.DoseSelectionButtons
import com.amsterdam.caffeine.presentation.CustomizeOrderScreen.component.SizeSelectionButtons
import com.amsterdam.caffeine.presentation.CustomizeOrderScreen.viewmodel.CaffeineDose
import com.amsterdam.caffeine.presentation.CustomizeOrderScreen.viewmodel.CupSize
import com.amsterdam.caffeine.presentation.CustomizeOrderScreen.viewmodel.CustomizeOrderUiState

@Composable
fun CustomizeOrderScreenContent(
    coffeeTypeTitle: String,
    onBackClick: () -> Unit,
    uiState: CustomizeOrderUiState,
    updateCupSize: (CupSize) -> Unit,
    updateCaffeineSize: (CaffeineDose) -> Unit,
    hideTopBar: () -> Unit,
    onContinueClick: (Int) -> Unit
) {
    val cupHeight by animateDpAsState(
        targetValue = when (uiState.cupSize) {
            CupSize.SMALL -> 180.dp
            CupSize.MEDIUM -> 240.dp
            CupSize.LARGE -> 300.dp
        },
        label = "",
        animationSpec = tween(500)
    )
    val cupWidth by animateDpAsState(
        targetValue = when (uiState.cupSize) {
            CupSize.SMALL -> 150.dp
            CupSize.MEDIUM -> 200.dp
            CupSize.LARGE -> 245.dp
        },
        label = "",
        animationSpec = tween(500)
    )
    val screenHeight =
        with(LocalDensity.current) { LocalConfiguration.current.screenHeightDp.dp.toPx().toDp() }
    val coffeeOffsetAnim = remember { Animatable(-screenHeight.value) }
    var previousSize by remember { mutableStateOf(uiState.caffeineDose) }
    LaunchedEffect(uiState.caffeineDose) {
        if (uiState.caffeineDose != previousSize) {
            val goingDown = uiState.caffeineDose > previousSize
            if (goingDown) {
                coffeeOffsetAnim.snapTo(-screenHeight.value)
                coffeeOffsetAnim.animateTo(
                    targetValue = (cupHeight * 0.5f).value,
                    animationSpec = tween(durationMillis = 1500)
                )
            } else {
                coffeeOffsetAnim.snapTo((cupHeight * 0.5f).value)
                coffeeOffsetAnim.animateTo(
                    targetValue = -screenHeight.value * 0.9f,
                    animationSpec = tween(durationMillis = 1500)
                )
            }
            previousSize = uiState.caffeineDose
        }
    }
    val coffeeSize by animateDpAsState(
        targetValue = when (uiState.cupSize) {
            CupSize.SMALL -> 98.dp
            CupSize.MEDIUM -> 125.dp
            CupSize.LARGE -> 140.dp
        }, animationSpec = tween(500)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .verticalScroll(
                state = rememberScrollState(), enabled = true
            )
            .padding(vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        AnimatedVisibility(
            visible = uiState.isTopBarVisible,
            exit = slideOutVertically(tween(300), targetOffsetY = { -it }),
            enter = fadeIn(tween(10000)),
        ) {
            BackButton(
                title = coffeeTypeTitle,
                onBackClick = onBackClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .defaultMinSize(minHeight = 65.dp)
                    .padding(bottom = 16.dp)
            )
        }
        Spacer(Modifier.weight(1f))
        CupAnimation(
            uiState = uiState,
            coffeeSize = coffeeSize,
            coffeeOffsetAnimation = coffeeOffsetAnim.value,
            cupHeight = cupHeight,
            cupWidth = cupWidth
        )
        SizeSelectionButtons(
            uiState = uiState,
            updateCupSize = updateCupSize,
        )

        DoseSelectionButtons(
            uiState = uiState,
            updateSelectedCaffeineSize = updateCaffeineSize,
        )

        Spacer(Modifier.weight(1f))
        ContinueButton(
            onContinueClick = onContinueClick, uiState = uiState, hideTopBar = hideTopBar
        )
    }
}