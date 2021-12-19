package ru.ilya.pushin.birthdaysappchallenge.features.birthdays.data.repositories

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.ilya.pushin.birthdaysappchallenge.features.birthdays.data.api.UsersApi
import ru.ilya.pushin.birthdaysappchallenge.features.birthdays.data.mappers.UserMapper
import ru.ilya.pushin.birthdaysappchallenge.features.birthdays.domain.models.User
import javax.inject.Inject

private const val NUMBER = 1000
private const val SEED = "chalkboard"
private const val INCLUDE = "name,dob"

class UserRepository @Inject constructor(
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val api: UsersApi,
    private val mapper: UserMapper
) {

    suspend fun getUsers() : List<User> = withContext(dispatcher) {
        mapper.mapEntitiesToUsers(api.getUsers(NUMBER, SEED, INCLUDE))
    }
}
