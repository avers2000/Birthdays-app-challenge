package ru.ilya.pushin.birthdaysappchallenge.features.birthdays.data.api

import retrofit2.http.GET
import retrofit2.http.Query
import ru.ilya.pushin.birthdaysappchallenge.features.birthdays.data.models.Entity

interface UsersApi {

    @GET("api/")
    suspend fun getUsers(
        @Query("results") results: Int,
        @Query("seed") seed: String,
        @Query("inc") include: String,
    ) : List<Entity>
}

