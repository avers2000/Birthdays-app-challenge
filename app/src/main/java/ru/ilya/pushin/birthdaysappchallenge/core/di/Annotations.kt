package ru.ilya.pushin.birthdaysappchallenge.core.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class MainCoroutineDispatcher

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class IoCoroutineDispatcher

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class DefaultCoroutineDispatcher

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ApplicationCoroutineScope

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class AuthApi
