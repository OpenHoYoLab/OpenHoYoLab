package io.openhoyolab.lab

import android.os.Build

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
    override val osName: String = "Android"
}

actual fun getPlatform(): Platform = AndroidPlatform()