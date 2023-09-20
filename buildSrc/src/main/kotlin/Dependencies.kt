@file:Suppress("ClassName")

import org.gradle.api.artifacts.dsl.RepositoryHandler
import java.net.URI
import java.util.*

object Versions {
    // application versioning versions
    const val compileSdkVersion = 34
    const val minSdkVersion = 24
    const val targetSdkVersion = 34
    const val versionCode = 1
    const val versionName = "1.0.0"
    const val jvmTargerVersion = "17"

    // android libraries versions
    const val androidLegacySupportVersion = "1.0.0"
    const val androidxCoreKtxVersion = "1.12.0"
    const val activityComposeVersion = "1.7.2"
    const val splashScreenVersion = "1.0.0"

    // lifecycle
    const val lifecycleVersion = "2.6.1"

    const val kotlinVersion = "1.9.0"
    const val coroutineVersion = "1.6.4"
    const val androidKtxVersion = "1.7.1"
    const val navigationComposeVersion = "2.7.1"
    const val composeVersion = "1.5.0"
    const val materialVersion = "1.9.0"
    const val paging3Version = "3.1.1"
    const val paging3ComposeVersion = "1.0.0-alpha18"

    // network
    const val retrofitVersion = "2.9.0"
    const val okhttpVersion = "4.10.0"

    // gson version
    const val gsonVersion = "2.10"

    //dagger version
    const val hiltVersion = "2.48"
    const val hiltNavigationComposeVersion = "1.0.0"

    // test libraries version
    const val junit5Version = "5.9.2"
    const val mockkVersion = "1.13.5"
    const val testJsonVersion = "20220924"

    // androidTest libraries version
    const val archCoreVersion = "2.2.0"
    const val coroutineTestVersion = "1.7.1"
    const val mockWebserverVersion = "4.7.2"

    // cache
    const val roomVersion = "2.5.2"

    const val coilVersion = "2.4.0"

    const val fragmentVersion = "1.6.1"
    const val navVersion = "1.6.1"
}

@Suppress("unused")
object Deps {

    const val androidLegacySupport =
        "androidx.legacy:legacy-support-v4:${Versions.androidLegacySupportVersion}"
    const val androidxCoreKtx = "androidx.core:core-ktx:${Versions.androidxCoreKtxVersion}"
    const val material = "com.google.android.material:material:${Versions.materialVersion}"
    const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragmentVersion}"
    const val navFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navVersion}"

    const val viewModelKtx =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleVersion}"
    const val lifecycleKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleVersion}"

    const val coroutines =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutineVersion}"
    const val activityKtx = "androidx.activity:activity-ktx:${Versions.androidKtxVersion}"
    const val activityCompose =
        "androidx.activity:activity-compose:${Versions.activityComposeVersion}"
    const val splashScreen = "androidx.core:core-splashscreen:${Versions.splashScreenVersion}"
    const val composeUi = "androidx.compose.ui:ui:${Versions.composeVersion}"
    const val composeMaterial = "androidx.compose.material:material:${Versions.composeVersion}"
    const val composeUiToolingPreview =
        "androidx.compose.ui:ui-tooling-preview:${Versions.composeVersion}"
    const val navigationCompose =
        "androidx.navigation:navigation-compose:${Versions.navigationComposeVersion}"
    const val composeLiveData =
        "androidx.compose.runtime:runtime-livedata:${Versions.composeVersion}"
    const val pagingThree = "androidx.paging:paging-runtime:${Versions.paging3Version}"
    const val pagingThreeCompose =
        "androidx.paging:paging-compose:${Versions.paging3ComposeVersion}"
    const val hilt = "com.google.dagger:hilt-android:${Versions.hiltVersion}"
    const val hiltNavigationCompose =
        "androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigationComposeVersion}"

    const val coil = "io.coil-kt:coil-compose:${Versions.coilVersion}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    const val retrofitGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofitVersion}"

    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttpVersion}"

    const val gson = "com.google.code.gson:gson:${Versions.gsonVersion}"
    const val room = "androidx.room:room-ktx:${Versions.roomVersion}"
    const val roomPaging = "androidx.room:room-paging:${Versions.roomVersion}"

    const val okhttpLogging = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttpVersion}"

    @JvmStatic
    fun isNonStable(version: String): Boolean {
        val stableKeyword =
            listOf("RELEASE", "FINAL", "GA").any { version.uppercase(Locale.ROOT).contains(it) }
        val regex = "^[0-9,.v-]+(-r)?$".toRegex()
        val isStable = stableKeyword || regex.matches(version)
        return isStable.not()
    }
}

object KaptDependencies {
    const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.hiltVersion}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.roomVersion}"
}

object TestDeps {
    const val junit5 = "org.junit.jupiter:junit-jupiter-engine:${Versions.junit5Version}"
    const val archCore = "androidx.arch.core:core-testing:${Versions.archCoreVersion}"
    const val coroutineTest =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutineTestVersion}"
    const val mockWebserver =
        "com.squareup.okhttp3:mockwebserver:${Versions.mockWebserverVersion}"
    const val mockkAndroid = "io.mockk:mockk-android:${Versions.mockkVersion}"
    const val mockkAgent = "io.mockk:mockk-agent:${Versions.mockkVersion}"
    const val testJson = "org.json:json:${Versions.testJsonVersion}"
}

object Repo {
    @JvmStatic
    fun addRepos(handler: RepositoryHandler) {
        handler.google()
        handler.mavenCentral()
        handler.maven { url = URI.create("https://jitpack.io") }
    }
}