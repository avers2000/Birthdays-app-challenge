package ru.ilya.pushin.birthdaysappchallenge.features.birthdays.data.mappers

import ru.ilya.pushin.birthdaysappchallenge.features.birthdays.data.models.Entity
import ru.ilya.pushin.birthdaysappchallenge.features.birthdays.data.models.Name
import ru.ilya.pushin.birthdaysappchallenge.features.birthdays.domain.models.User
import javax.inject.Inject

class UserMapper @Inject constructor() {

    fun mapEntitiesToUsers(entities: List<Entity>): List<User> {
        return entities.map {
            val name = composeName(it.name)
            User(
                name = name,
                shortName = shortenName(name),
                dob = it.dob.date,
                age = it.dob.age
            )
        }
    }

    internal fun composeName(name: Name): String {
        return buildString {
            append(name.first.trim())
            if (name.last.isNotBlank()) {
                append(" ")
                append(name.last.trim())
            }
        }
    }

    internal fun shortenName(name: String): String {
        val words = name.split(" ")

        return buildString {
            words.forEach {
                append(it.first().uppercase())
            }
        }
    }
}
