package io.openhoyolab.lab.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun DynamicTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme {
        content()
    }
}