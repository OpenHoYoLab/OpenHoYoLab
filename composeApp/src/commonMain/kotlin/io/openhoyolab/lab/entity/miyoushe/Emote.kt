package io.openhoyolab.lab.entity.miyoushe

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

@OptIn(ExperimentalSerializationApi::class)
@Serializable
data class EmoteSet(
    /**
     * 表情包的数字 id
     * The number id of the emotes set
     */
    val id: Int,
    /**
     * 表情包的名称
     * The name of the emotes set
     */
    val name: String,
    /**
     * 表情包封面的 url 地址
     * Url address of the set cover image
     */
    val icon: String,
    /**
     * 表情包排序权重
     * Sort order of the emotes set
     */
    @JsonNames("sort_order")
    val sortOrder: Int,
    /**
     * 这个表情包中有多少表情
     * How many emotes in this emotes set
     */
    @JsonNames("num")
    val amount: Int,
    /**
     * 当前的状态，PUBLISHED 为已发布的，DRAFT 为未发布的
     * Current status, PUBLISHED is published set, DRAFT is unpublished set
     */
    val status: EmoteStatus,
    /**
     * 此表情包中所有的表情
     * All emotes of this set
     */
    @JsonNames("list")
    val emotes: List<Emote>,
    /**
     * 最后一次更新的时间，为 unix 时间
     * Last updated time, it's unix time
     */
    @JsonNames("updated_at")
    val updateAt: Long,
    /**
     * 是否可以使用
     * If it's usable
     */
    @JsonNames("is_available")
    val isAvailable: Boolean
)

@OptIn(ExperimentalSerializationApi::class)
@Serializable
data class Emote(
    /**
     * 该表情的数字 id
     * The number id of this emote
     */
    val id: Int,
    /**
     * 该表情的名称
     * The name of this emote
     */
    val name: String,
    /**
     * 表情包的 url 地址
     * Url address of the emote image
     */
    val icon: String,
    /**
     * 表情排序权重
     * Sort order of the emote
     */
    @JsonNames("sort_order")
    val sortOrder: Int,
    /**
     * 静态图标，不知道有什么用
     * Static icon, have no idea what it is used to do
     */
    @JsonNames("static_icon")
    val staticIcon: String,
    /**
     * 最后一次更新的时间，为 unix 时间
     * Last updated time, it's unix time
     */
    @JsonNames("updated_at")
    val updateAt: Long,
    @JsonNames("is_available")
    /**
     * 是否可以使用
     * If it's usable
     */
    val isAvailable: Boolean,
    /**
     * 当前的状态，PUBLISHED 为已发布的，DRAFT 为未发布的
     * Current status, PUBLISHED is published set, DRAFT is unpublished set
     */
    val status: EmoteStatus,
    /**
     * 此表情的关键词，目前所有表情的关键词列表都是空的
     * The keywords of this emote, currently, all the emotes have empty keywords list
     */
    val keywords: Array<String>
)

/**
 * 表情与表情包的状态
 * Emote and Set status
 */
@Serializable
enum class EmoteStatus {
    /**
     * 未发布的
     * Unpublished
     */
    DRAFT,
    /**
     * 已发布的
     * Published
     */
    PUBLISHED
}