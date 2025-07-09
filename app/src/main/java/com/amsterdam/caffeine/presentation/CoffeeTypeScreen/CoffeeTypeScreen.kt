package com.amsterdam.caffeine.presentation.CoffeeTypeScreen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.amsterdam.caffeine.data.coffeeTypes
import com.amsterdam.caffeine.presentation.CoffeeTypeScreen.components.CoffeeTypePager
import com.amsterdam.caffeine.presentation.CoffeeTypeScreen.components.WelcomeSection
import com.amsterdam.caffeine.presentation.shared.ContinueButton
import com.amsterdam.caffeine.presentation.shared.TopAppBar
import com.amsterdam.caffeine.presentation.theme.ui.CaffeineWhiteColor

@Composable
fun CoffeeTypeScreen(
    onContinueClick: (coffeeType: String) -> Unit,
) {
    val coroutineScope = rememberCoroutineScope()

    var isNavigate by remember { mutableStateOf(false) }

    val coffeeTypes = coffeeTypes
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = CaffeineWhiteColor)
            .verticalScroll(
                state = rememberScrollState(), enabled = true
            )
            .padding(vertical = 16.dp), horizontalAlignment = Alignment.Start
    ) {

        AnimatedVisibility(
            visible = !isNavigate,
            exit = slideOutHorizontally(targetOffsetX = { -it }, animationSpec = tween(400)),
        ) {
            TopAppBar(
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }

        AnimatedVisibility(
            visible = !isNavigate,
            exit = slideOutHorizontally(targetOffsetX = { -it }, animationSpec = tween(400)),
        ) {
            WelcomeSection()
        }

        Spacer(modifier = Modifier.weight(1f))
        val pagerState = rememberPagerState(pageCount = { coffeeTypes.size })
        AnimatedVisibility(
            visible = !isNavigate,
            exit = fadeOut(animationSpec = tween(1000)),
        ) {
            CoffeeTypePager(
                modifier = Modifier.padding(bottom = 16.dp),
                pagerState = pagerState,
                coffeeTypes = coffeeTypes
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        AnimatedVisibility(
            visible = !isNavigate,
            exit = slideOutHorizontally(targetOffsetX = { -it }, animationSpec = tween(400)),
            modifier = Modifier
                .defaultMinSize(minHeight = 56.dp)
                .padding(horizontal = 32.dp, vertical = 18.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            ContinueButton(
                coroutineScope = coroutineScope,
                pagerState = pagerState,
                isNavigate = isNavigate,
                coffeeTypes = coffeeTypes,
                onContinueClick = onContinueClick
            )
        }
    }
}
