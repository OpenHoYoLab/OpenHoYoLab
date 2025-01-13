package io.openhoyolab.lab.ui.component

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab

/**
 * 将底边 tab 提成单独的函数，防止过多重复代码，易于维护
 * Extract separate composable function for bottom tab, preventing too much
 * duplicated code, easy to maintain
 * @param tab 对应的 tab | corresponding tab
 */
@Composable
fun RowScope.NavigationItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current

    NavigationBarItem(
        selected = tabNavigator.current == tab,
        onClick = { tabNavigator.current = tab },
        icon = {
            val icon = tab.options.icon
            if (icon != null) {
                Icon(painter = icon, contentDescription = tab.options.title)
            }
        }
    )
}