package io.openhoyolab.lab.network.miyoushe

import de.jensklingenberg.ktorfit.Ktorfit
import de.jensklingenberg.ktorfit.http.GET
import io.ktor.client.*
import io.openhoyolab.lab.network.JsonObjectResponseConverter
import kotlinx.serialization.json.JsonObject

class MiyousheClient {

    private val client: HttpClient
    private val ktorfit: Ktorfit
    val webapi: WebapiKtorfit

    init {
        this.client = HttpClient {
        }
        this.ktorfit = Ktorfit.Builder()
            .httpClient(this.client)
            .converterFactories(JsonObjectResponseConverter())
            .baseUrl("https://bbs-api-static.miyoushe.com/")
            .build()
        this.webapi = this.ktorfit.createWebapiKtorfit()
    }

}

/**
 * 用于调用米游社 API 的 Ktrofit 接口
 * Interface used to fetch Miyoushe API
 */
interface WebapiKtorfit {

    /**
     * 获取所有游戏
     * Fetch all the games
     * @return 游戏的列表
     * @return List of games
     */
    @GET("apihub/wapi/getGameList")
    suspend fun getGameList(): JsonObject

    /**
     * 获取表情包列表
     * Fetch all the emotes
     * @return 所有的表情包集
     * @return all sets of emotes
     */
    @GET("misc/api/emoticon_set")
    suspend fun getEmoteSets(): JsonObject

    /**
     * 获取所有游戏的论坛
     * Fetch all the forums of all games
     * @return 所有游戏的所有论坛
     * @return all forums of all games
     */
    @GET("apihub/wapi/getAllGamesForums")
    suspend fun getAllGamesForums(): JsonObject

    /**
     * 获取用户信息
     * Fetch user info
     * @return 如果登录则返回用户信息，否则返回错误
     * @return user info if logged-in, or else error
     */
    @GET("user/wapi/getUserFullInfo")
    suspend fun getUserFullInfo(): JsonObject

}