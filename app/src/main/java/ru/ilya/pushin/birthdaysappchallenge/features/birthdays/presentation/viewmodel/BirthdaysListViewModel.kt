package ru.ilya.pushin.birthdaysappchallenge.features.birthdays.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.ilya.pushin.birthdaysappchallenge.features.birthdays.data.repositories.UserRepository
import ru.ilya.pushin.birthdaysappchallenge.features.birthdays.domain.models.User
import javax.inject.Inject

@HiltViewModel
class BirthdaysListViewModel @Inject constructor(
    private val repository: UserRepository
) {

    private val _users = MutableLiveData(listOf<User>())
    val users = _users as LiveData<List<User>>

    init {

    }
}
