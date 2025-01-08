package io.openhoyolab.lab.entity.miyoushe

import kotlinx.serialization.Serializable

/**
 * 游戏实体，可以通过 API 获取
 * Game Entity, which can be fetched from API
 */
@Serializable
data class Game(
    /**
     * 游戏的数字 ID，多数情况都会使用此 ID 来标注游戏
     * The number ID of the game, this will be used to mark the game in most situation
     */
    val id: Int,
    /**
     * 游戏的中文名称
     * The Chinese name of the game
     */
    val name: String,
    /**
     * 游戏的英文名称
     * The English name of the game
     */
    val enName: String,
    /**
     * 游戏图标的 URL 地址，该图标为 216x216 大小
     * The URL address of game icon, of which size is 216x216
     */
    val appIcon: String,
    /**
     * 游戏图标的 URL 地址，该图标为 48x48 大小
     * The URL address of game icon, of which size is 48x48
     */
    val icon: String,
    /**
     * 搜索趋势，目前作用不明
     * Search Trending, its usage is uncertain for now
     */
    val searchTrendWord: String,
    /**
     * 等级图片，目前作用不明
     * Level Image, its usage is uncertain for now
     */
    val levelImage: String,
    /**
     * 等级文本颜色，目前作用不明
     * The color of level text, its usage is uncertain for now
     */
    val levelTextColor: String,
    /**
     * 话题数量，目前作用不明
     * Topic number, its usage is uncertain for now
     */
    val topicNum: Int,
    /**
     * 作用不明
     * Its usage is uncertain for now
     */
    val opName: String,
    /**
     * 主色，游戏图标的主要色（不一定会在图标中占很大面积）
     * Main color, the important color in game icon (Not always the most part in game icon)
     */
    val mainColor: String,
    /**
     * 是否存在百科
     * Whether wiki exists
     */
    val hasWiki: Boolean,
    /**
     * 游戏排序配置，目前作用不明
     * Game sort config, its usage is uncertain for now
     */
    val gameSortConfig: List<GameSortConfig>
)

/**
 * 游戏排序配置，目前作用不明
 * Game sort config, its usage is uncertain for now
 */
@Serializable
data class GameSortConfig(
    val name: String,
    val type: Int,
    val url: String,
    val showSort: Int,
    val dataReportName: String
)