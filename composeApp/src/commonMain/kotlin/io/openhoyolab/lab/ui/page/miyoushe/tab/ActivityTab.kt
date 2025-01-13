package io.openhoyolab.lab.ui.page.miyoushe.tab

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Celebration
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import io.openhoyolab.resource.Res
import io.openhoyolab.resource.miyoushe_tab_activity
import org.jetbrains.compose.resources.stringResource

object ActivityTab : Tab {
    override val options: TabOptions
        @Composable
        get() {
            val title = stringResource(Res.string.miyoushe_tab_activity)
            val icon = rememberVectorPainter(Icons.Filled.Celebration)

            return remember {
                TabOptions(
                    index = 1u,
                    title = title,
                    icon = icon
                )
            }
        }

    @Composable
    override fun Content() {

    }

}