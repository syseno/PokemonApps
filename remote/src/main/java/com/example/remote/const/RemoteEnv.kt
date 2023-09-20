package com.example.remote.const

import com.example.core_remote.BuildConfig

object RemoteEnv {
    init {
        System.loadLibrary(BuildConfig.ENVARS_LIB)
    }

    external fun getBaseUrl(): String
}