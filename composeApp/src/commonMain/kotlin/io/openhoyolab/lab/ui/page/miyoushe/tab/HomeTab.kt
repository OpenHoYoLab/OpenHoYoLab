package io.openhoyolab.lab.ui.page.miyoushe.tab

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Card
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.currentCompositeKeyHash
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import coil3.ImageLoader
import coil3.compose.AsyncImage
import io.openhoyolab.lab.ui.component.LoadingProgess
import io.openhoyolab.lab.ui.page.miyoushe.tab.models.ListGamesModel
import io.openhoyolab.resource.Res
import io.openhoyolab.resource.miyoushe_tab_home
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.koinInject

/**
 * 米游社的主页，用于浏览论坛内容
 * Home of Miyoushe, used to view forum content
 */
object HomeTab : Tab {

    /**
     * 此页面的选项，用于定义底边栏的图标和显示名称
     * The options of this page, to define the icon and title shown in bottom tab bar
     */
    override val options: TabOptions
        @Composable
        get() {
            val title = stringResource(Res.string.miyoushe_tab_home)
            val icon = rememberVectorPainter(Icons.Filled.Home)

            return remember {
                TabOptions(
                    index = 0u,
                    title = title,
                    icon = icon
                )
            }
        }

    /**
     * 该页面的实际内容显示
     * Actual content display of this page
     */
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        /**
         * 通过 koin 获取到注入的 ImageLoader
         * Get ImageLoader injected with koin
         */
        val imageLoader = koinInject<ImageLoader>()

        /**
         * 所有使用的 ScreenModel
         * All used ScreenModels
         */
        val listGamesModel = rememberScreenModel {
            ListGamesModel()
        }

        /**
         * ScreenModel 对应的状态
         * States related to ScreenModels
         */
        val listGamesState by listGamesModel.state.collectAsState()

        /**
         * 确保所有游戏都加载完后再显示实际内容
         * Make sure all the games are loaded then show the actual content
         */
        when (listGamesState) {
            /**
             * 如果还在加载，就显示加载动画
             * If it's still loading, show loading animation
             */
            is ListGamesModel.State.Loading -> {
                /**
                 * 使用 Box 来将加载动画锚定在画面中央
                 * Use Box to align the loading animation in center of whole view
                 */
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    LoadingProgess()
                }
            }

            /**
             * 不在加载则已经加载完成，开始进行实际内容的显示
             * If not loading, means games are all loaded, starting show actual content
             */
            else -> {
                /**
                 * 将状态转换为结果，以便拿取数据
                 * Cast state to result, to get result data
                 */
                val result = listGamesState as ListGamesModel.State.Result

                val games = result.games

                /**
                 * 当前显示的游戏，使用可保存以防止切换界面后丢失选定的游戏
                 * Currently showing game, use saveable to prevent lost selected game after switching page
                 */
                var selectedGame by rememberSaveable {
                    mutableStateOf(games[0])
                }

                /**
                 * 用于操作抽屉
                 * Use to control drawer
                 */
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                val scope = rememberCoroutineScope()

                /**
                 * 添加抽屉，用于选择当前查看的游戏
                 * Add drawer to select current game to view
                 */
                ModalNavigationDrawer(
                    drawerState = drawerState,
                    drawerContent = {
                        /**
                         * 抽屉的内容
                         * Content of the drawer
                         */
                        ModalDrawerSheet {
                            /**
                             * 遍历所有的游戏
                             * Traverse all the games
                             */
                            for (game in games) {
                                /**
                                 * 如果此游戏与选定的游戏一样，添加底色来确定当前选定的游戏
                                 * If this game is selected game, add background color to highlight it
                                 */
                                if (game == selectedGame) {
                                    Card {
                                        Row(
                                            modifier = Modifier.fillMaxWidth().height(64.dp),
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            AsyncImage(
                                                model = game.icon,
                                                contentDescription = game.name,
                                                imageLoader = imageLoader,
                                                modifier = Modifier.size(48.dp)
                                                    .padding(8.dp)
                                            )
                                            Text(
                                                text = game.name
                                            )
                                        }
                                    }
                                } else {
                                    /**
                                     * 如果此游戏与当前选定的游戏一样，不添加底色，但是添加点击事件用于切换
                                     * If this game is not selected, no background color, but click event to switch
                                     */
                                    Row(
                                        modifier = Modifier.fillMaxWidth()
                                            .height(64.dp)
                                            .clickable {
                                                selectedGame = game
                                            },
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        AsyncImage(
                                            model = game.icon,
                                            contentDescription = game.name,
                                            imageLoader = imageLoader,
                                            modifier = Modifier.size(48.dp)
                                                .padding(8.dp)
                                        )
                                        Text(
                                            text = game.name
                                        )
                                    }
                                }
                            }
                        }
                    },
                ) {
                    /**
                     * 页面的实际内容
                     * Actual content of the page
                     */
                    Column(
                        modifier = Modifier.fillMaxSize(),
                    ) {
                        /**
                         * 顶部一行用于显示当前选择的游戏
                         * Top bar used to show currently selected game
                         */
                        Row(
                            modifier = Modifier.fillMaxWidth()
                                .height(64.dp)
                                .clickable {
                                    scope.launch {
                                        drawerState.open()
                                    }
                                },
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            AsyncImage(
                                model = selectedGame.icon,
                                contentDescription = selectedGame.name,
                                imageLoader = imageLoader,
                                modifier = Modifier.size(48.dp)
                                    .padding(8.dp)
                            )
                            Text(
                                text = selectedGame.name
                            )
                        }
                    }
                }
            }
        }
        /**
         * 当 UI 显示出来后再进行游戏列表获取操作，这样才能做到缓存且不浪费资源
         * Fetch game list after UI appearing, to avoid memory waste
         */
        LaunchedEffect(currentCompositeKeyHash) {
            listGamesModel.listGames()
        }
    }

}