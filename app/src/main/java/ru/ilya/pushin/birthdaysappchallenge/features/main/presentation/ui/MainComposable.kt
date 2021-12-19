package ru.ilya.pushin.birthdaysappchallenge

import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.ilya.pushin.birthdaysappchallenge.features.birthdays.domain.models.User
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
                    navigateToInfoScreen = { user ->
                        navController.currentBackStackEntry?.arguments?.putSerializable(Screen.BirthdayInfo.route, user)
                        navController.navigate(Screen.BirthdayInfo.route)
                    }
                )
            }
            composable(Screen.BirthdayInfo.route) {
                val user = navController.previousBackStackEntry?.arguments?.getSerializable(
                    Screen.BirthdayInfo.route
                ) as User

                BirthdayInfoComposable(
                    user = user,
                    navigateBack = { navController.popBackStack() }
                )
            }
        }
    }
}
