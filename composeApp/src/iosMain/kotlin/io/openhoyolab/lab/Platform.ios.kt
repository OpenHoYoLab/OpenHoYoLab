package io.openhoyolab.lab

import platform.UIKit.UIDevice

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
    override val osName: String = "iOS"
}

actual fun getPlatform(): Platform = IOSPlatform()