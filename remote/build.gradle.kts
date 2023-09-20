plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    id("org.jetbrains.kotlin.kapt")
}

android {
    namespace = "com.example.core_remote"
    compileSdk = Versions.compileSdkVersion

    defaultConfig {
        minSdk = Versions.minSdkVersion

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
        externalNativeBuild {
            cmake {
                arguments += "-DBUILD_TYPE=dev"
            }
        }

        buildConfigField("String", "ENVARS_LIB", "\"remoteenvars-dev\"")
    }

    buildFeatures {
        buildConfig = true
    }

    buildTypes {
        debug {
            externalNativeBuild {
                cmake {
                    arguments += "-DBUILD_TYPE=dev"
                }
            }
            buildConfigField("String", "ENVARS_LIB", "\"remoteenvars-dev\"")
        }

        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            externalNativeBuild {
                cmake {
                    arguments += "-DBUILD_TYPE=rel"

                }
            }
            buildConfigField("String", "ENVARS_LIB", "\"remoteenvars\"")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = Versions.jvmTargerVersion
    }

    externalNativeBuild {
        cmake {
            path = File("jni/CMakeLists.txt")
        }
    }
}

dependencies {

    // Retrofit
    api(Deps.retrofit)
    api(Deps.retrofitGson)
    api(Deps.okhttp)
    api(Deps.okhttpLogging)

    // Paging 3
    implementation(Deps.pagingThree)

    // Hilt
    implementation(Deps.hilt)
    kapt(KaptDependencies.hiltCompiler)
    implementation(project(":test"))
}