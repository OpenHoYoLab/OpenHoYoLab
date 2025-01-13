package io.openhoyolab.lab.util

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

/**
 * 定义了一些源游社专门使用的子 CoroutineScope
 * Declared sub-CoroutineScopes for OpenHoYoLab
 */
object Scopes {

    val Network = CoroutineScope(Dispatchers.IO)

}