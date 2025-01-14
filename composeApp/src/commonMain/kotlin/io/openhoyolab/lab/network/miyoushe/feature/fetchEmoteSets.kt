package io.openhoyolab.lab.network.miyoushe.feature

import io.openhoyolab.lab.entity.miyoushe.EmoteSet
import io.openhoyolab.lab.network.miyoushe.MiyousheClient
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.decodeFromJsonElement


/**
 * 获取表情包列表
 * Fetch all the emotes
 *
 * @return 所有的表情包集
 * @return all sets of emotes
 */
// TODO: 这个接口也能获取到用户最近使用的表情包列表，应该独立处理
// TODO: This interface can also fetch recently used emotes by user, should be resolved separately
suspend fun MiyousheClient.fetchEmoteSets(): List<EmoteSet> {
    return this.webapi.getEmoteSets()
        .run { this["data"] as JsonObject }
        .run { this["list"] as JsonArray }
        .map { it as JsonObject }
        .map { Json.decodeFromJsonElement<EmoteSet>(it) }
        .toList()
}