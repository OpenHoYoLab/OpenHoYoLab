package io.openhoyolab.lab.ui.page

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import io.openhoyolab.lab.ui.page.miyoushe.MiyoushePage
import io.openhoyolab.resource.Res
import io.openhoyolab.resource.hoyolab
import io.openhoyolab.resource.hoyolab_user
import io.openhoyolab.resource.miyoushe
import io.openhoyolab.resource.miyoushe_user
import org.jetbrains.compose.resources.imageResource
import org.jetbrains.compose.resources.stringResource

/**
 * 用户第一次启动源游社时显示的页面，让用户选择使用米游社还是 HoYoLAB
 * Page to show when user first launching OpenHoYoLab, to let user choose Miyoushe or HoYoLAB to use
 */
object FirstLaunchingPage : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        LocalDensity.current
        /**
         * 使用列来进行排列
         * Use Column to navigate components
         */
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            /**
             * 用间隔和权重来使选项居中
             * Use Spacer and weight to center choices
             */
            Spacer(Modifier.weight(1f))
            /**
             * 选项1：米游社，仅在中国大陆（国服）使用
             * Choice 1: Miyoushe, only used in China mainland (China server)
             */
            Community(
                bitmap = imageResource(Res.drawable.miyoushe),
                contentDescription = stringResource(Res.string.miyoushe),
                text = stringResource(Res.string.miyoushe_user),
                onClick = {
                    navigator.replace(MiyoushePage)
                }
            )
            /**
             * 在两个选项之间添加间隔来
             * Add spacer between two choices
             */
            Spacer(Modifier.height(32.dp))
            /**
             * 选项2：HoYoLAB，在全世界（海外服）使用
             * Choice 2: HoYoLAB, used in Globe (Oversea server)
             */
            Community(
                bitmap = imageResource(Res.drawable.hoyolab),
                contentDescription = stringResource(Res.string.hoyolab),
                text = stringResource(Res.string.hoyolab_user),
                onClick = {

                }
            )
            /**
             * 用间隔和权重来使选项居中
             * Use Spacer and weight to center choices
             */
            Spacer(Modifier.weight(1f))
        }
    }

}

/**
 * 为防止过多重复代码，将社区分成独立控件
 * To avoid duplicated code, create a separated Community component
 * @param bitmap 社区图标的 bitmap | the bitmap of the community icon
 * @param contentDescription 社区名称，应该被本地化 | the name of the community, should be localized
 * @param text 社区名称，应该被本地化 | the name of the community, should be localized
 * @param onClick 打开社区的实现 | click to go to community page
 */
@Composable
private fun Community(
    bitmap: ImageBitmap,
    contentDescription: String,
    text: String,
    onClick: () -> Unit
) {
    /**
     * 使用按钮来选择社区
     * Use button to choose the community
     */
    Button(
        modifier = Modifier.heightIn(max = 200.dp)
            .width(IntrinsicSize.Max),
        onClick = onClick
    ) {
        /**
         * 社区的图标
         * the icon of the community
         */
        Image(
            bitmap = bitmap,
            contentDescription = contentDescription,
            modifier = Modifier.size(64.dp)
        )
        /**
         * 使用间隔和权重，保证图标在左边，文字在右边
         * Use spacer and weight, ensure icon on the left and text on the right
         */
        Spacer(Modifier.weight(1f))
        /**
         * 社区的名称
         * the name of the community
         */
        Text(
            text = text,
            modifier = Modifier.padding(16.dp)
        )
    }
}