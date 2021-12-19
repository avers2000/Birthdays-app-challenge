package ru.ilya.pushin.birthdaysappchallenge.features.birthdays.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.ilya.pushin.birthdaysappchallenge.features.birthdays.data.repositories.UserRepository
import ru.ilya.pushin.birthdaysappchallenge.features.birthdays.domain.models.User
import javax.inject.Inject

@HiltViewModel
class BirthdaysListViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    private val _users = MutableLiveData(listOf<User>())
    val users = _users as LiveData<List<User>>

    init {
        viewModelScope.launch {
            _users.value = repository.getUsers()
        }
    }
}
