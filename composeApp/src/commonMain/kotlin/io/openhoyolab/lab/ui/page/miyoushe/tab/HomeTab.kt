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

object HomeTab : Tab {
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

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        val imageLoader = koinInject<ImageLoader>()

        val screenModel = rememberScreenModel {
            ListGamesModel()
        }
        val state by screenModel.state.collectAsState()
        when (state) {
            is ListGamesModel.State.Loading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    LoadingProgess()
                }
            }

            else -> {
                val result = state as ListGamesModel.State.Result

                val games = result.games
                var selectedGame by remember {
                    mutableStateOf(games[0])
                }

                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                val scope = rememberCoroutineScope()

                ModalNavigationDrawer(
                    drawerState = drawerState,
                    drawerContent = {
                        ModalDrawerSheet {
                            for (game in games) {
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
                    Column(
                        modifier = Modifier.fillMaxSize(),
                    ) {
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
            screenModel.listGames()
        }
    }

}