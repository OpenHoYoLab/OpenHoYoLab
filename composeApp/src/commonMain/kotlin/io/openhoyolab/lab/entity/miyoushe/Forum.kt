package io.openhoyolab.lab.entity.miyoushe

import io.openhoyolab.lab.annotation.UnknownUsage
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

/**
 * 由于这些实体的数据有太多无用以及未知用途的数据，暂时不做标注
 * Due to these entities have too many useless and unknown-usage data, temporarily no comments
 */

@OptIn(ExperimentalSerializationApi::class)
@Serializable
data class GameForums(
    @JsonNames("game_id")
    val gameId: Int,
    val forums: Array<Forum>,
)

@Serializable
data class BasicForum(
    val id: Int,
    val name: String,
)

@OptIn(ExperimentalSerializationApi::class)
@Serializable
data class Forum(
    val id: Int,
    @JsonNames("game_id")
    val gameId: Int,
    val name: String,
    val order: Int,
    @UnknownUsage
    val f_id: Int,
    val visible: Int, // 1 for true, 0 for false
    @UnknownUsage
    val create_type: Int,
    @UnknownUsage
    val view_type: Int,
    @UnknownUsage
    val post_limit: Int,
    @UnknownUsage
    val max_top: Int,
    @UnknownUsage
    val post_order: String,
    @UnknownUsage
    val src_type: Int,
    val icon: String,
    @JsonNames("header_image")
    val headerImage: String,
    @UnknownUsage
    val hot_score: Int,
    @JsonNames("icon_pure")
    val iconPure: String,
    @JsonNames("des")
    val description: String,
    @UnknownUsage
    val post_num: Int,
    @UnknownUsage
    val today_post: Int,
    @UnknownUsage
    val reply_type: Int,
    @UnknownUsage
    val edit_post: Int,
    @JsonNames("created_at")
    val createdAt: String,
    @JsonNames("updatedat")
    val updatedAt: String,
    @UnknownUsage
    val show_type: Int,
    @UnknownUsage
    val default_tab: Int,
    @JsonNames("read_me")
    val readme: String,
    @JsonNames("forum_cate_list")
    val forumCates: Array<ForumCate>,
    @JsonNames("video_cate_list")
    val videoCates: Array<ForumCate>
)

@OptIn(ExperimentalSerializationApi::class)
@Serializable
data class ForumCate(
    val id: Int,
    val name: String,
    @JsonNames("forum_id")
    val forumId: Int,
    @JsonNames("desc")
    val description: String,
    val remark: String
)