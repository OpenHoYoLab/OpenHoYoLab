package io.openhoyolab.lab.ui.page.miyoushe

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import io.openhoyolab.lab.ui.component.NavigationItem
import io.openhoyolab.lab.ui.page.miyoushe.tab.ActivityTab
import io.openhoyolab.lab.ui.page.miyoushe.tab.HomeTab
import io.openhoyolab.lab.ui.page.miyoushe.tab.MessageTab
import io.openhoyolab.lab.ui.page.miyoushe.tab.UserTab

/**
 * 米游社社区的页面
 * Miyoushe community page
 */
object MiyoushePage : Screen {

    @Composable
    override fun Content() {
        /**
         * 底部 Tab 的实现，切换这四个页面：主页，动态，消息，我的
         * Implementation of bottom tab, to switch these four pages: Home, Activity, Message, User
         */
        TabNavigator(HomeTab) {
            /**
             * 使用 Scaffold，以添加底边 Tab
             * Use Scaffold, to add bottom tab
             */
            Scaffold(
                bottomBar = {
                    NavigationBar {
                        NavigationItem(HomeTab)
                        NavigationItem(ActivityTab)
                        NavigationItem(MessageTab)
                        NavigationItem(UserTab)
                    }
                }
            ) { paddingValues ->
                /**
                 * 使用 Surface，通过 paddingValues 添加避让区，优雅的实现各个 tab 的显示
                 * Use Surface, add avoidance zone with paddingValues, to gracefully implement display of each tab
                 */
                Surface(
                    modifier = Modifier.padding(paddingValues)
                        .fillMaxSize()
                ) {
                    /**
                     * Voyager 库中的函数，用于显示当前的 tab
                     * Function in voyager library, to display current tab
                     */
                    CurrentTab()
                }
            }
        }
    }

}