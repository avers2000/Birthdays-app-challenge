package ru.ilya.pushin.birthdaysappchallenge.features.birthdays.domain.models

import java.io.Serializable
import java.util.Date

data class User(
    val name: String,
    val shortName: String,
    val dob: Date,
    val age: Int
) : Serializable
