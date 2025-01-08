import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.plugin.serialization)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.ksp)
    alias(libs.plugins.ktorfit)
}

kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }

    jvm("desktop")

    sourceSets {
        val desktopMain by getting
        // ios Main are not declared in source sets,goto iosApp to write features for iOS

        // andoird has jvm, so safe to use jvm libraries here, but andoird libraries are better
        androidMain.dependencies {
            // Ktor platform
            implementation(libs.ktor.client.android)

            // compose
            implementation(compose.preview)

            // androidx
            implementation(libs.androidx.activity.compose)
        }

        appleMain.dependencies {
            // Ktor platform
            implementation(libs.ktor.client.darwin)
        }

        // common should only contains code and libraries related to kotlin itself
        commonMain.dependencies {
            // Koin
            implementation(libs.koin.compose)
            implementation(libs.koin.composeViewmodel)
            implementation(libs.koin.composeViewmodelNavigation)

            // Voyager
            implementation(libs.voyager.navigator)
            implementation(libs.voyager.screenmodel)
            implementation(libs.voyager.bottomSheetNavigator)
            implementation(libs.voyager.tabNavigator)
            implementation(libs.voyager.transitions)
            implementation(libs.voyager.koin)

            // Coil Image
            implementation(libs.coil.compose)
            implementation(libs.coil.network.ktor3)

            // KotlinX Serialization (Json parsing)
            implementation(libs.kotlinx.serialization.json)

            // Ktor & Ktorfit (Networking)
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.cio)
            implementation(libs.ktorfit)
            implementation(libs.ktorfit.converters.call)
            implementation(libs.ktorfit.converters.flow)
            implementation(libs.ktorfit.converters.response)

            // Jetpack Compose
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.materialIconsExtended)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.androidx.lifecycle.runtime.compose)
        }

        // desktop supports jvm, so safe to use any jvm libraries here
        desktopMain.dependencies {
            // Ktor platform
            implementation(libs.ktor.client.java)

            // compose
            implementation(compose.desktop.currentOs)

            // kotlinx
            implementation(libs.kotlinx.coroutines.swing)
        }
    }
}

android {
    namespace = "io.openhoyolab.lab"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "io.openhoyolab.lab"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    debugImplementation(compose.uiTooling)
}

compose.desktop {
    application {
        mainClass = "io.openhoyolab.lab.MainKt" // here declared the main class of the app

        buildTypes.release.proguard {
            // compiling problem, have to disable
            // luckily, this is an open-sourced project
            // no obfuscation need
            isEnabled.set(false)
        }

        nativeDistributions {
            // .dmg for macOS, .msi for Microsoft Windows, .deb for Linux distros based on Debian
            // I don't know how to package kmp project to different packages like .rpm (for Linux distros based Red Hat)
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "io.openhoyolab.lab"
            packageVersion = "1.0.0"

            windows {
                iconFile.set(project.file("/resources/logo.ico"))
            }
            macOS {
                iconFile.set(project.file("/resources/logo.icns"))
            }
            linux {
                iconFile.set(project.file("/resources/logo.png"))
            }
        }
    }
}

compose.resources {
    publicResClass = true
    packageOfResClass = "io.openhoyolab.resource"
    generateResClass = always
}