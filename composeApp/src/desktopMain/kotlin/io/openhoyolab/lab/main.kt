package io.openhoyolab.lab

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import io.openhoyolab.resource.Res
import io.openhoyolab.resource.app_name
import io.openhoyolab.resource.logo_rounded
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import java.awt.Dimension

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = stringResource(Res.string.app_name),
        icon = painterResource(Res.drawable.logo_rounded),
    ) {
        window.minimumSize = Dimension(800, 600)
        App()
    }
}