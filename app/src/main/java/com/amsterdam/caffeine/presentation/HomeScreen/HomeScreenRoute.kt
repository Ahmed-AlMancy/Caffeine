package com.amsterdam.caffeine.presentation.HomeScreen

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.amsterdam.caffeine.presentation.CoffeeTypeScreen.navigateToCoffeeTypeScreen
import com.amsterdam.caffeine.presentation.Navigation.Screens


fun NavGraphBuilder.homeScreenRoute(navController: NavController) {
    composable(
        route = Screens.HomeScreen.route,
    ) {
        HomeScreen(
            onButtonClick = {
                navController.navigateToCoffeeTypeScreen()
            })
    }
}

fun NavController.navigateToHomeScreen() {
    navigate(Screens.HomeScreen.route)
}