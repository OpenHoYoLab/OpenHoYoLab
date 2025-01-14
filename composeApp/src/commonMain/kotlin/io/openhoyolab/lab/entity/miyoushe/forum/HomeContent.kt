package io.openhoyolab.lab.entity.miyoushe.forum

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

// TODO: 由于网页版的 api，返回的同一种东西，比如 user，在不同接口中数据量不同，所以需要抽象出很多个不同的 User 类，这样子，所以这种数据
// TODO: 多又复杂的东西现在有点懒得做

@OptIn(ExperimentalSerializationApi::class)
@Serializable
data class HomeContent(
    val carousels: Array<Carousel>,/*
    @JsonNames("recommended_posts")
    val recommendedPosts:*/
)

@Serializable
data class Carousel(
    val cover: String,
    val path: String
)
