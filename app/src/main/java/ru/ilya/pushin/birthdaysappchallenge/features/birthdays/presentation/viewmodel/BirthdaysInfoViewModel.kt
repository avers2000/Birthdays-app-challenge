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
class BirthdaysInfoViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    private val _user = MutableLiveData<User>()
    val user = _user as LiveData<User>

    fun getUser(userId: Int) {
        viewModelScope.launch {
            _user.value = repository.getUsers()[userId]
        }
    }
}
