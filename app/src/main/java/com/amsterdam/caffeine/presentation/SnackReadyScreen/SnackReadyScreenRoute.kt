package com.amsterdam.caffeine.presentation.SnackReadyScreen

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.amsterdam.caffeine.presentation.Navigation.Screens

fun NavGraphBuilder.snacksReadyScreenRoute(navController: NavController) {
    composable(
        route = Screens.SnackReadyScreen.route,
        arguments = listOf(
            navArgument("snackID") { type = NavType.IntType }
        ),
    ) { backStackEntry ->
        val snackID = backStackEntry.arguments?.getInt("snackID") ?: 0

        SnackReadyScreen(
            snackID = snackID, onConfirmClick = {
                navController.popBackStack(Screens.HomeScreen.route, inclusive = false)
            }, onCloseClick = {
                navController.popBackStack(Screens.HomeScreen.route, inclusive = false)
            })
    }
}

fun NavController.navigateToSnackReadyScreen(snackID: Int) {
    navigate(Screens.SnackReadyScreen.createRoute(snackID))
}
