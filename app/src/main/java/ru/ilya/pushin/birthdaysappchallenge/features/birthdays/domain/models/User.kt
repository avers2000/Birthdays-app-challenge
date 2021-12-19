package ru.ilya.pushin.birthdaysappchallenge.features.birthdays.domain.models

import java.util.Date

data class User(
    val name: String,
    val dob: Date,
    val age: Int
)
