package ru.ilya.pushin.birthdaysappchallenge.features.birthdays.data.mappers

import ru.ilya.pushin.birthdaysappchallenge.features.birthdays.data.models.Entity
import ru.ilya.pushin.birthdaysappchallenge.features.birthdays.data.models.Name
import ru.ilya.pushin.birthdaysappchallenge.features.birthdays.domain.models.User
import javax.inject.Inject

class UserMapper @Inject constructor() {

    fun mapEntitiesToUsers(entities: List<Entity>): List<User> {
        return entities.map {
            User(
                name = composeName(it.name),
                dob = it.dob.date,
                age = it.dob.age
            )
        }
    }

    fun composeName(name: Name) : String {
        return buildString {
            append(name.first)
            if (name.last.isNotBlank()) {
                append(" ")
                append(name.last)
            }
        }
    }
}
