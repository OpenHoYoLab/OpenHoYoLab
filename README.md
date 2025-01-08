<h1 align="center">OpenHoYoLab</h1>
<p align="center">An open-sourced HoYoLab app powered by Jetpack Compose & Kotlin Multiplatform.</p>
<p align="center">English | <a href="./README_CN.md">简体中文</a></p>

Developed with [Jetbrains Fleet](https://www.jetbrains.com/fleet/).

## Roadmap
- [ ] [※※※※※] Support for HarmonyOS (Waiting for KMP support)
- [ ] [※※※※] Browse threads in forums
- [ ] [※※※※] Check-ins
- [ ] [※※※※] Live stream (Version event)
- [ ] ...

## Contribution
It's welcomed to contribute your code and your idea to this project, as I can't spend all of my time on this project, help from others like you seems very important. \
 \
I have to declare that if you want to contribute to this project, whatever your native language is, there must be English introduction in docs comment. \
If your native language is Chinese or you learn about Chinese, you have to write Chinese docs upon English docs. \
For Example, this is allowed:
```kotlin
/**
 * 用于调用米游社 API 的 Ktrofit 接口
 * Interface used to fetch Miyoushe API
 */
interface MiyousheKtorfit {

    /**
     * 获取所有游戏
     * Fetch all the games
     * @return 游戏的列表
     * @return List of games
     */
    @GET("apihub/wapi/getGameList")
    suspend fun getGameList(): List<Game>

}
```
This is not allowed:
```kotlin
interface MiyousheKtorfit {

    @GET("apihub/wapi/getGameList")
    suspend fun getGameList(): List<Game>

}
```
Additionally, though I haven't add code format file now, you shouldn't contribute code without format.