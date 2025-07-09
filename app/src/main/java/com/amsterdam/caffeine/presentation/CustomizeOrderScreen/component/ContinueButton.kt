package com.amsterdam.caffeine.presentation.CustomizeOrderScreen.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.amsterdam.caffeine.R
import com.amsterdam.caffeine.presentation.CustomizeOrderScreen.viewmodel.CustomizeOrderUiState
import com.amsterdam.caffeine.presentation.theme.ui.CaffeineBlackColor
import com.amsterdam.caffeine.presentation.theme.ui.CaffeineWhiteColor
import com.amsterdam.caffeine.presentation.theme.ui.urbanist_bold
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun ContinueButton(
    onContinueClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
    uiState: CustomizeOrderUiState,
    hideTopBar: () -> Unit
) {
    val coroutineScope = rememberCoroutineScope()
    Button(
        modifier = modifier
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
            ), colors = ButtonColors(
            containerColor = CaffeineBlackColor,
            contentColor = CaffeineWhiteColor,
            disabledContainerColor = CaffeineWhiteColor,
            disabledContentColor = CaffeineBlackColor
        ), onClick = {
            coroutineScope.launch(Dispatchers.Main) {
                hideTopBar()
                delay(700)
                hideTopBar()
                onContinueClick(uiState.cupSize.size)
            }
        }) {
        Text(
            text = "Continue",
            textAlign = TextAlign.Start,
            fontFamily = urbanist_bold,
            fontSize = 16.sp,
            lineHeight = 18.sp,
            letterSpacing = 0.25.sp,
        )
        Icon(
            painter = painterResource(R.drawable.arrow_right),
            contentDescription = null,
            modifier = Modifier
                .padding(start = 8.dp)
                .size(24.dp)
        )
    }
}