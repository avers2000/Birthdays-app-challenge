package ru.ilya.pushin.birthdaysappchallenge.features.birthdays.data.repositories

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import ru.ilya.pushin.birthdaysappchallenge.core.di.IoCoroutineDispatcher
import ru.ilya.pushin.birthdaysappchallenge.features.birthdays.data.api.UsersApi
import ru.ilya.pushin.birthdaysappchallenge.features.birthdays.data.mappers.UserMapper
import ru.ilya.pushin.birthdaysappchallenge.features.birthdays.domain.models.User
import javax.inject.Inject

private const val NUMBER = 1000
private const val SEED = "chalkboard"
private const val INCLUDE = "name,dob"

class UserRepository @Inject constructor(
    @IoCoroutineDispatcher private val dispatcher: CoroutineDispatcher,
    private val api: UsersApi,
    private val mapper: UserMapper
) {

    private val inMemoryCache = mutableListOf<User>()

    suspend fun getUsers(): List<User> = withContext(dispatcher) {
        if (inMemoryCache.isNotEmpty()) {
            return@withContext inMemoryCache
        }

        inMemoryCache.addAll(mapper.mapEntitiesToUsers(api.getUsers(NUMBER, SEED, INCLUDE).results))
        inMemoryCache
    }
}
