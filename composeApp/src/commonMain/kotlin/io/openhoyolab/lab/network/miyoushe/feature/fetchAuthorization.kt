package io.openhoyolab.lab.network.miyoushe.feature

import io.openhoyolab.lab.entity.miyoushe.auth.Authorization
import io.openhoyolab.lab.network.miyoushe.MiyousheClient
import kotlinx.serialization.json.intOrNull
import kotlinx.serialization.json.jsonPrimitive

/**
 * 获取用户信息
 * Fetch user info
 * @return 如果登录则返回用户信息，否则返回错误
 * @return user info if logged-in, or else error
 */
suspend fun MiyousheClient.fetchAuthorization(): Authorization {
    val value = this.webapi.getUserFullInfo()
    if (value["retcode"]?.jsonPrimitive?.intOrNull == 0) {
        // TODO: 获取登录后用户的信息
    }
    return Authorization.Unauthorized
}