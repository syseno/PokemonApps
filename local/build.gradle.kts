plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    id("org.jetbrains.kotlin.kapt")
}

android {
    namespace = "com.example.core_local"
    compileSdk = Versions.compileSdkVersion

    defaultConfig {
        minSdk = Versions.minSdkVersion

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = Versions.jvmTargerVersion
    }
}

dependencies {
    // Room
    api(Deps.room)
    api(Deps.roomPaging)
    kapt(KaptDependencies.roomCompiler)

    // Paging 3
    implementation(Deps.pagingThree)
    implementation(Deps.pagingThreeCompose)

    implementation(Deps.gson)

    // Hilt
    implementation(Deps.hilt)
    kapt(KaptDependencies.hiltCompiler)
    implementation(project(":test"))
}