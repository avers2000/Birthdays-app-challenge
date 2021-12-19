package ru.ilya.pushin.birthdaysappchallenge.features.birthdays.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ru.ilya.pushin.birthdaysappchallenge.R
import ru.ilya.pushin.birthdaysappchallenge.features.birthdays.presentation.viewmodel.BirthdaysInfoViewModel

@Composable
fun BirthdayInfoComposable(
    viewModel: BirthdaysInfoViewModel = hiltViewModel(),
    userId: Int,
    navigateBack: () -> Unit,
) {
    LaunchedEffect(userId) {
        viewModel.getUser(userId)
    }

    val user by viewModel.user.observeAsState(null)

    user?.let {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.size(96.dp),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h2,
                text = it.shortName
            )
            Text(
                style = MaterialTheme.typography.h4,
                text = it.name
            )
            Text(stringResource(R.string.age, it.age))

            Button(onClick = navigateBack) {
                Text(stringResource(id = R.string.go_back))
            }
        }
    }
}
