package io.openhoyolab.lab.entity.miyoushe

/**
 * 帖子内容似乎没有 api，然后首页获取的大部分帖子的链接都是相对于主链接的路径，所以需要用 id 获取对应的 url
 * Thread content seems to have no api, and threads urls fetched from home are all relative path, so need id to get url
 */
sealed class UrlMappings(
    val gameId: Int,
    val baseUrl: String
) {

    object GenshinMappings : UrlMappings(2, "https://www.miyoushe.com/ys/")

    companion object {

        val VALUES = arrayOf(
            GenshinMappings
        )

        fun getById(id: Int): UrlMappings {
            return VALUES.find { it.gameId == id }!!
        }

    }

}