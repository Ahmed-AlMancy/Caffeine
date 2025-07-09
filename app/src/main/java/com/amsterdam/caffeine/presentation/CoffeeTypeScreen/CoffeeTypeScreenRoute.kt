package com.amsterdam.caffeine.presentation.CoffeeTypeScreen

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.amsterdam.caffeine.presentation.CustomizeOrderScreen.navigateToCustomizeOrderScreen
import com.amsterdam.caffeine.presentation.Navigation.Screens

fun NavGraphBuilder.coffeeTypeScreenRoute(navController: NavController) {
    composable(
        route = Screens.CoffeeTypeScreen.route,
    ) {
        CoffeeTypeScreen(
            onContinueClick = {
                navController.navigateToCustomizeOrderScreen(it)
            }
        )
    }
}

fun NavController.navigateToCoffeeTypeScreen() {
    navigate(Screens.CoffeeTypeScreen.route)
}