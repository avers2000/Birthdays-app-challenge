package ru.ilya.pushin.birthdaysappchallenge.features.birthdays.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ru.ilya.pushin.birthdaysappchallenge.R
import ru.ilya.pushin.birthdaysappchallenge.features.birthdays.domain.models.User

@Composable
fun BirthdayInfoComposable(
    user: User,
    navigateBack: () -> Unit,
) {
    Column(
        modifier = Modifier.padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.size(96.dp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h2,
            text = user.shortName
        )
        Text(
            style = MaterialTheme.typography.h4,
            text = user.name
        )
        Text(stringResource(id = R.string.age, user.age))

        Button(onClick = navigateBack) {
            Text(stringResource(id = R.string.go_back))
        }
    }
}
