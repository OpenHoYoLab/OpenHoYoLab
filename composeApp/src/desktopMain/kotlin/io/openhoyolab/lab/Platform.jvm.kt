package io.openhoyolab.lab

import androidx.compose.ui.text.toLowerCase

class JVMPlatform: Platform {
    override val name: String = "Java ${System.getProperty("java.version")}"
    override val osName: String
        get() {
            val osName = System.getProperty("os.name").lowercase()
            return if (osName.contains("windows")) {
                "Windows"
            } else if (osName.contains("darwin") || osName.contentEquals("macos")) {
                "macOS"
            } else {
                "Linux"
            }
        }
}

actual fun getPlatform(): Platform = JVMPlatform()