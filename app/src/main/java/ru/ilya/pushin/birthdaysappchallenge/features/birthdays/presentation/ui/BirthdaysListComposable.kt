package ru.ilya.pushin.birthdaysappchallenge.features.birthdays.presentation.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ru.ilya.pushin.birthdaysappchallenge.features.birthdays.domain.models.User
import ru.ilya.pushin.birthdaysappchallenge.features.birthdays.presentation.viewmodel.BirthdaysListViewModel
import java.text.SimpleDateFormat

@Composable
fun BirthdaysListComposable(
    viewModel: BirthdaysListViewModel = hiltViewModel(),
    navigateToInfoScreen: (user: Int) -> Unit
) {
    val list by viewModel.users.observeAsState(listOf())

    UsersList(
        list = list,
        navigateToInfoScreen = navigateToInfoScreen
    )
}

@Composable
internal fun UsersList(list: List<User>, navigateToInfoScreen: (user: Int) -> Unit) {
    LazyColumn {
        itemsIndexed(
            items = list, key = { index, item ->
                item.hashCode()
            }
        ) { index, item ->
            UserRow(
                user = item,
                index = index,
                navigateToInfoScreen = navigateToInfoScreen
            )
        }
    }
}

@Composable
internal fun UserRow(user: User, index: Int, navigateToInfoScreen: (user: Int) -> Unit) {
    val dob = remember(user.dob) { SimpleDateFormat("dd-MM-yyyy").format(user.dob) }

    Row(
        modifier = Modifier
            .height(64.dp)
            .fillMaxWidth()
            .clickable { navigateToInfoScreen(index) }
            .padding(8.dp)
    ) {
        Text(
            modifier = Modifier.size(64.dp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h4,
            text = user.shortName
        )
        Column(modifier = Modifier.padding(start = 8.dp)) {
            Text(
                style = MaterialTheme.typography.subtitle2,
                text = user.name
            )
            Text(dob)
        }
    }
}
