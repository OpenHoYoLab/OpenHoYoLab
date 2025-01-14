package io.openhoyolab.lab.network.miyoushe.feature

import io.openhoyolab.lab.entity.miyoushe.GameForums
import io.openhoyolab.lab.network.miyoushe.MiyousheClient
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.decodeFromJsonElement

/**
 * 获取所有游戏的论坛
 * Fetch all the forums of all games
 * @return 所有游戏的所有论坛
 * @return all forums of all games
 */
suspend fun MiyousheClient.listAllForums(): List<GameForums> {
    return this.webapi.getAllGamesForums()
        .run { this["data"] as JsonObject }
        .run { this["list"] as JsonArray }
        .map { it as JsonObject }
        .map { Json.decodeFromJsonElement<GameForums>(it) }
        .toList()
}