package ru.ilya.pushin.birthdaysappchallenge.features.birthdays.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import ru.ilya.pushin.birthdaysappchallenge.features.birthdays.data.api.UsersApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BirthdaysSingletonModule {

    @Singleton
    @Provides
    fun provideSitRepMapJsonApi(retrofit: Retrofit): UsersApi {
        return retrofit.create(UsersApi::class.java)
    }
}
