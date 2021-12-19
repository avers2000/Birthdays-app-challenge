package ru.ilya.pushin.birthdaysappchallenge.features.main.presentation.navigation

sealed class Screen(val route: String) {
    object BirthdaysList: Screen("birthdays-list")
    object BirthdayInfo: Screen("birthday-info")
}
