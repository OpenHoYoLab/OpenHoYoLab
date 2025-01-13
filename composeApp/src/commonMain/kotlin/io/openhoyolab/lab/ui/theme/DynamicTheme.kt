package io.openhoyolab.lab.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

// FIXME: 临时的主题实现，待替换 | Temporary implementation for theme, to be replaced
@Composable
fun DynamicTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme {
        content()
    }
}