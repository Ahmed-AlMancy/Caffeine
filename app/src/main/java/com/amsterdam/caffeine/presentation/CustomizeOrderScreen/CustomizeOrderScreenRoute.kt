package com.amsterdam.caffeine.presentation.CustomizeOrderScreen

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.amsterdam.caffeine.presentation.CustomizeOrderScreen.viewmodel.CustomizeOrderViewModel
import com.amsterdam.caffeine.presentation.Navigation.Screens
import com.amsterdam.caffeine.presentation.SnacksScreen.navigateToSnacksScreen


fun NavGraphBuilder.customizeOrderScreenRoute(navController: NavController) {
    val viewModel = CustomizeOrderViewModel()
    composable(
        route = Screens.CustomizeOrderScreen.route,
    ) { backStackEntry ->
        val coffeeType = backStackEntry.arguments?.getString("coffeeType") ?: "Unknown"
        CustomizeOrderScreen(coffeeTypeTitle = coffeeType, onBackClick = {
            navController.popBackStack()
        }, viewModel = viewModel, onContinueClick = {
            navController.navigateToSnacksScreen()
        })
    }
}

fun NavController.navigateToCustomizeOrderScreen(coffeeType: String) {
    navigate(Screens.CustomizeOrderScreen.createRoute(coffeeType))
}