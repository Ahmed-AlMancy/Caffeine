package com.amsterdam.caffeine.presentation.Navigation


sealed class Screens(val route: String) {
    object HomeScreen : Screens("home_screen")
    object CoffeeTypeScreen : Screens("coffee_type_screen")
    object CustomizeOrderScreen : Screens("customize_order_screen/{coffeeType}") {
        fun createRoute(coffeeType: String): String =
            "customize_order_screen/${coffeeType}"
    }

    object SnacksScreen : Screens("snacks_screen")
    object SnackReadyScreen : Screens("snack_ready_screen/{snackID}") {
        fun createRoute(snackID: Int): String =
            "snack_ready_screen/${snackID}"
    }
}