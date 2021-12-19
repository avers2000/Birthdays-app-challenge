package ru.ilya.pushin.birthdaysappchallenge

import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import ru.ilya.pushin.birthdaysappchallenge.features.birthdays.presentation.ui.BirthdayInfoComposable
import ru.ilya.pushin.birthdaysappchallenge.features.birthdays.presentation.ui.BirthdaysListComposable
import ru.ilya.pushin.birthdaysappchallenge.features.main.presentation.navigation.Screen

@Composable
fun Main(
    navController: NavHostController = rememberNavController(),
) {
    Scaffold(
        scaffoldState = rememberScaffoldState()
    ) {
        NavHost(navController = navController, startDestination = Screen.BirthdaysList.route) {
            composable(Screen.BirthdaysList.route) {
                BirthdaysListComposable(
                    navigateToInfoScreen = { userId ->
                        navController.navigate("birthday-info/$userId")
                    }
                )
            }
            composable(
                "birthday-info/{userId}",
                arguments = listOf(navArgument("userId") { type = NavType.IntType })
            ) {
                BirthdayInfoComposable(
                    userId = it.arguments?.getInt("userId") ?: 0,
                    navigateBack = { navController.popBackStack() }
                )
            }
        }
    }
}
