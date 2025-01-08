package io.openhoyolab.lab.network

import de.jensklingenberg.ktorfit.Ktorfit
import de.jensklingenberg.ktorfit.http.GET
import io.ktor.client.*
import io.openhoyolab.lab.entity.miyoushe.Game

class MiyousheClient {

    private val client: HttpClient
    private val ktorfit: MiyousheKtorfit

    init {
        this.client = HttpClient {
        }
        this.ktorfit = Ktorfit.Builder()
            .baseUrl("https://bbs-api-static.miyoushe.com/")
            .build()
            .create()
    }

}

/**
 * 用于调用米游社 API 的 Ktrofit 接口
 * Interface used to fetch Miyoushe API
 */
interface MiyousheKtorfit {

    /**
     * 获取所有游戏
     * Fetch all the games
     * @return 游戏的列表
     * @return List of games
     */
    @GET("apihub/wapi/getGameList")
    suspend fun getGameList(): List<Game>

}