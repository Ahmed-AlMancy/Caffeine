package com.amsterdam.caffeine.presentation.CustomizeOrderScreen.viewmodel

data class CustomizeOrderUiState(
    val cupSize: CupSize = CupSize.SMALL,
    val caffeineDose: CaffeineDose = CaffeineDose.LOW,
    val isTopBarVisible: Boolean = true
)

enum class CupSize(val size: Int) {
    SMALL(150),
    MEDIUM(200),
    LARGE(400)
}

enum class CaffeineDose() {
    LOW,
    MEDIUM,
    HIGH
}