package io.openhoyolab.lab.ui.page.miyoushe.tab.models

import cafe.adriel.voyager.core.model.StateScreenModel
import io.openhoyolab.lab.entity.miyoushe.Game
import io.openhoyolab.lab.network.miyoushe.MiyousheClient
import io.openhoyolab.lab.network.miyoushe.feature.listGames
import io.openhoyolab.lab.util.Scopes
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

/**
 * 获取游戏列表用的 ScreenModel
 * ScreenModel to fetch game list
 */
class ListGamesModel : StateScreenModel<ListGamesModel.State>(State.Loading), KoinComponent {

    /**
     * 定义状态
     * Declare the state
     */
    sealed class State {
        object Loading : State()
        data class Result(val games: List<Game>) : State()
    }

    /**
     * 获取所有的游戏
     * Fetch all the games
     */
    fun listGames() {
        if (games == null) {
            val client = get<MiyousheClient>()
            Scopes.Network.launch {
                games = client.listGames()
                this@ListGamesModel.mutableState.value = State.Result(games!!)
            }
        } else {
            this.mutableState.value = State.Result(games!!)
        }
    }

    companion object {

        /**
         * 游戏列表的缓存，在重启之前不会刷新，因为一年甚至两三年才会添加一次新游戏
         * Cache of game list, will not be refreshed before relaunching,
         * because it usually requires a year or 2 or 3 years to publish a new game
         */
        private var games: List<Game>? = null

    }

}