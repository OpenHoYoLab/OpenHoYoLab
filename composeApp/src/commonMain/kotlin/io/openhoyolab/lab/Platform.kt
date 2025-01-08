package io.openhoyolab.lab

interface Platform {
    val name: String
    val osName: String
}

expect fun getPlatform(): Platform