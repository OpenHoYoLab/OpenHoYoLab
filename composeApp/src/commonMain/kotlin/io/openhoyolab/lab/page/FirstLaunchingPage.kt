package io.openhoyolab.lab.page

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
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalGraphicsContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import cafe.adriel.voyager.core.screen.Screen
import io.openhoyolab.resource.Res
import io.openhoyolab.resource.hoyolab
import io.openhoyolab.resource.hoyolab_user
import io.openhoyolab.resource.miyoushe
import io.openhoyolab.resource.miyoushe_user
import org.jetbrains.compose.resources.imageResource
import org.jetbrains.compose.resources.stringResource

/**
 * Page to show when user first launching OpenHoYoLab, to let user choose Miyoushe or HoYoLAB to use
 * 用户第一次启动源游社时显示的页面，让用户选择使用米游社还是 HoYoLAB
 */
class FirstLaunchingPage : Screen {

    @Composable
    override fun Content() {
        val density = LocalDensity.current
        val context =
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.weight(1f))
            Community(
                bitmap = imageResource(Res.drawable.miyoushe),
                contentDescription = stringResource(Res.string.miyoushe),
                text = stringResource(Res.string.miyoushe_user),
                onClick = {

                }
            )
            Spacer(Modifier.height(32.dp))
            Community(
                bitmap = imageResource(Res.drawable.hoyolab),
                contentDescription = stringResource(Res.string.hoyolab),
                text = stringResource(Res.string.hoyolab_user),
                onClick = {

                }
            )
            Spacer(Modifier.weight(1f))
        }
    }

}

@Composable
private fun Community(
    bitmap: ImageBitmap,
    contentDescription: String,
    text: String,
    onClick: () -> Unit
) {
    Button(
        modifier = Modifier.heightIn(max = 200.dp)
            .width(IntrinsicSize.Max),
        onClick = onClick
    ) {
        Image(
            bitmap = bitmap,
            contentDescription = contentDescription,
            modifier = Modifier.size(64.dp)
        )
        Spacer(Modifier.weight(1f))
        Text(
            text = text,
            modifier = Modifier.padding(16.dp)
        )
    }
}