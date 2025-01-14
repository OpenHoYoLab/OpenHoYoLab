package io.openhoyolab.lab.network.miyoushe.feature

import io.openhoyolab.lab.entity.miyoushe.Game
import io.openhoyolab.lab.network.miyoushe.MiyousheClient


/**
 * 获取主页内容，注意这个是网页版的主页，所以大部分都是固定内容
 * Fetch home content, attention this is home of web version, so most content will not change after refreshing
 */
suspend fun MiyousheClient.fetchHome(game: Game, page: Int = 1, pageSize: Int = 20) {

}