package io.openhoyolab.lab

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.Navigator
import io.openhoyolab.lab.page.FirstLaunchingPage
import io.openhoyolab.lab.theme.DynamicTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

import org.koin.compose.KoinApplication

@Composable
@Preview
fun App() {
    KoinApplication(application = {
    }) {
        DynamicTheme {
            Navigator(FirstLaunchingPage()) {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    CurrentScreen()
                }
            }
        }
    }
    
}