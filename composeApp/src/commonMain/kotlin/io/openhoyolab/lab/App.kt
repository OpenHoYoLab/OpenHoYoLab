package io.openhoyolab.lab

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.Navigator
import coil3.ImageLoader
import coil3.compose.LocalPlatformContext
import io.openhoyolab.lab.network.miyoushe.MiyousheClient
import io.openhoyolab.lab.ui.page.FirstLaunchingPage
import io.openhoyolab.lab.ui.theme.DynamicTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

import org.koin.compose.KoinApplication
import org.koin.dsl.module

/**
 * 软件的入口
 * Entrance of the software
 */
@Composable
@Preview
fun App() {
    /**
     * 使用 koin 进行依赖注入，解决一些问题
     * Use koin to implement dependency inject, solve some problems
     */
    val platformContext = LocalPlatformContext.current
    KoinApplication(application = {
        modules(
            module {
                /**
                 * 用于图片加载器的单例
                 * Single instance for ImageLoader
                 */
                single<ImageLoader> {
                    ImageLoader.Builder(platformContext)
                        .components {
                            // TODO: gif decoder
                        }
                        .build()
                }
                /**
                 * 米游社网络客户端单例
                 * Single instance for Miyoushe network client
                 */
                single<MiyousheClient> {
                    MiyousheClient()
                }
            }
        )
    }) {
        DynamicTheme {
            Navigator(FirstLaunchingPage) {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    CurrentScreen()
                }
            }
        }
    }

}