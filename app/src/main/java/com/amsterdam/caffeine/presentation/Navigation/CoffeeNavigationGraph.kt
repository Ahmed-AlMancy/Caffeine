package com.amsterdam.caffeine.presentation.Navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.amsterdam.caffeine.presentation.CoffeeTypeScreen.coffeeTypeScreenRoute
import com.amsterdam.caffeine.presentation.CustomizeOrderScreen.customizeOrderScreenRoute
import com.amsterdam.caffeine.presentation.HomeScreen.homeScreenRoute
import com.amsterdam.caffeine.presentation.SnackReadyScreen.snacksReadyScreenRoute
import com.amsterdam.caffeine.presentation.SnacksScreen.snacksScreenRoute

fun NavGraphBuilder.coffeeNavigationGraph(navController: NavHostController) {
    homeScreenRoute(navController)
    coffeeTypeScreenRoute(navController)
    customizeOrderScreenRoute(navController)
    snacksScreenRoute(navController)
    snacksReadyScreenRoute(navController)
}