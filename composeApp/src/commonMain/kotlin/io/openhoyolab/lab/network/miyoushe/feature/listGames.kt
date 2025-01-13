package io.openhoyolab.lab.network.miyoushe.feature

import io.openhoyolab.lab.entity.miyoushe.Game
import io.openhoyolab.lab.network.miyoushe.MiyousheClient
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.decodeFromJsonElement

suspend fun MiyousheClient.listGames(): List<Game> {
    return this.webapi.getGameList()
        .run { this["data"] as JsonObject }
        .run { this["list"] as JsonArray }
        .map { it as JsonObject }
        .map { Json.decodeFromJsonElement<Game>(it) }
        .toList()
}