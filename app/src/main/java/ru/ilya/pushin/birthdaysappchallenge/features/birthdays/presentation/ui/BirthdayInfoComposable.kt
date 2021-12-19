package ru.ilya.pushin.birthdaysappchallenge.features.birthdays.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.ilya.pushin.birthdaysappchallenge.features.birthdays.domain.models.User

@Composable
fun BirthdayInfoComposable(
    user: User,
    navigateBack: () -> Unit,
) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(
            style = MaterialTheme.typography.subtitle2,
            text = user.name
        )
    }
}
