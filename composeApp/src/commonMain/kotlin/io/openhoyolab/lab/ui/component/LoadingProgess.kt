package io.openhoyolab.lab.ui.component

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable

/**
 * 加载时的转圈圈动画，考虑到不同系统不同，所以单独的处理
 * 安卓：圆圈 + 渐变色
 * iOS：类似时钟的灰色渐变
 * 鸿蒙：星球环绕
 * Animation for loading, considering different os has different animation, so there is a separate component
 * Android: Circle + Gradient color
 * iOS: gray gradient in a clock-like circle
 * HarmonyOS: satellite orbiting a planet
 */
@Composable
fun LoadingProgess() {
    // FIXME: 由于实现限制，暂时先用 compose 自带的加载 | Due to implementation limit, temporarily using compose provided
    CircularProgressIndicator()
}