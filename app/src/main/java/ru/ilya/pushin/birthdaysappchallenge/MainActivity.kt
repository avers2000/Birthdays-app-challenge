package ru.ilya.pushin.birthdaysappchallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import dagger.hilt.android.AndroidEntryPoint
import ru.ilya.pushin.birthdaysappchallenge.core.theme.BirthdaysAppChallangeTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BirthdaysAppChallangeTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Main()
                }
            }
        }
    }
}
