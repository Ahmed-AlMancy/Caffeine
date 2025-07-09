package com.amsterdam.caffeine.presentation.SnacksScreen

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.amsterdam.caffeine.presentation.Navigation.Screens
import com.amsterdam.caffeine.presentation.SnackReadyScreen.navigateToSnackReadyScreen


fun NavGraphBuilder.snacksScreenRoute(navController: NavController) {
    composable(
        route = Screens.SnacksScreen.route,
    ) {
        SnacksScreen(
            onCloseClick = {
                navController.popBackStack(Screens.HomeScreen.route, inclusive = false)
            },
            onSnackClick = {
                navController.navigateToSnackReadyScreen(it)
            })
    }
}


fun NavController.navigateToSnacksScreen() {
    navigate(Screens.SnacksScreen.route)
}