package io.openhoyolab.lab.network.miyoushe

import de.jensklingenberg.ktorfit.Ktorfit
import de.jensklingenberg.ktorfit.http.GET
import io.ktor.client.*
import io.openhoyolab.lab.network.JsonObjectResponseConverter
import kotlinx.serialization.json.JsonObject

class MiyousheClient {

    private val client: HttpClient
    val webapi: WebapiKtorfit

    init {
        this.client = HttpClient {
        }
        this.webapi = Ktorfit.Builder()
            .converterFactories(JsonObjectResponseConverter())
            .baseUrl("https://bbs-api-static.miyoushe.com/")
            .build()
            .createWebapiKtorfit()
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

}