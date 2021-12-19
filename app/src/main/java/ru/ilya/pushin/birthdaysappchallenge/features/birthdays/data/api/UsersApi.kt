package ru.ilya.pushin.birthdaysappchallenge.features.birthdays.data.api

import retrofit2.http.GET
import retrofit2.http.Query
import ru.ilya.pushin.birthdaysappchallenge.features.birthdays.data.models.UsersResponse

interface UsersApi {

    @GET("api/")
    suspend fun getUsers(
        @Query("results") results: Int,
        @Query("seed") seed: String,
        @Query("inc") include: String,
    ) : UsersResponse
}

