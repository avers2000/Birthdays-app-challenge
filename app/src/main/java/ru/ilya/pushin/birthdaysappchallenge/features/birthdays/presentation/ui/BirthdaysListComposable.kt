package ru.ilya.pushin.birthdaysappchallenge.features.birthdays.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import ru.ilya.pushin.birthdaysappchallenge.features.birthdays.domain.models.User
import ru.ilya.pushin.birthdaysappchallenge.features.birthdays.presentation.viewmodel.BirthdaysListViewModel

@Composable
fun BirthdaysListComposable(
    viewModel: BirthdaysListViewModel = hiltViewModel(),
    navController: NavController
) {
    val list by viewModel.users.observeAsState(listOf())

    UsersList(
        list = list
    )
}

@Composable
internal fun UsersList(list: List<User>) {
    LazyColumn {
        items(list) {
            UserRow(user = it)
        }
    }
}

@Composable
internal fun UserRow(user: User) {
    val dob = remember { user.dob.toString() }

    Row {
        Text(user.shortName)
        Column {
            Text(user.name)
            Text(dob)
        }
    }
}
