plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    id("org.jetbrains.kotlin.kapt")
}

android {
    namespace = "com.example.pokemonapps"
    compileSdk = Versions.compileSdkVersion

    defaultConfig {
        applicationId = "com.example.pokemonapps"
        minSdk = Versions.minSdkVersion
        targetSdk = Versions.targetSdkVersion
        versionCode = Versions.versionCode
        versionName = Versions.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }
}

dependencies {

    implementation(project(":foundation"))
    implementation(project(":local"))
    implementation(project(":remote"))

    implementation(Deps.androidxCoreKtx)
    implementation(Deps.lifecycleKtx)
    implementation(Deps.coroutines)
    implementation(Deps.viewModelKtx)
    implementation(Deps.composeLiveData)
    implementation(Deps.navigationCompose)

    // Paging 3
    implementation(Deps.pagingThree)
    implementation(Deps.pagingThreeCompose)

    // Hilt
    implementation(Deps.hilt)
    kapt(KaptDependencies.hiltCompiler)

    implementation(project(":test"))
}