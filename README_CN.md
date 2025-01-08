<img src="./resources/logo.png" style="display: block; width: 128px; height: 128px; margin-left: auto; margin-right: auto;" ></img>
<h1 align="center">开源米游社</h1>
<p align="center">一个通过 Jetpack Compose 及 Kotlin Multiplatform 实现的开源米游社 App。</p>
<p align="center"><a href="./README.md">English</a> | 简体中文</p>

使用 [Jetbrains Fleet](https://www.jetbrains.com/fleet/) 进行开发.

## 路线图
- [ ] [※※※※※] 原生鸿蒙系统支持（等待 KMP 适配中）
- [ ] [※※※※] 浏览论坛中的帖子
- [ ] [※※※※] 签到
- [ ] [※※※※] 直播 (版本前瞻)
- [ ] ...


## 贡献
欢迎您为此项目贡献您的代码和想法，因为我不可能将我的所有精力投入在这个项目上，其他人比如您的帮助就显得尤为重要. \
 \
我不得不声明一下，如果您想为此项目做贡献，无论您的母语是什么，请务必在文档注释中添加英文介绍. \
如果您的母语是中文，或是您了解中文，也请您同时在英文的介绍上方添加中文介绍. \
举个例子，这个是允许的:
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
这是不允许的:
```kotlin
interface MiyousheKtorfit {

    @GET("apihub/wapi/getGameList")
    suspend fun getGameList(): List<Game>

}
```
此外，虽然我还没添加代码格式化文件，但并不意味着您可以贡献没有格式化过的代码.