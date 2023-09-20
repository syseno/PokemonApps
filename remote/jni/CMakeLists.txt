cmake_minimum_required(VERSION 3.18.0)

include_directories(jni/include/)

set(BUILD_TYPE "" CACHE STRING "Select which build-types are being used")
message("Using environment for BUILD_TYPE=${BUILD_TYPE}")

if (BUILD_TYPE STREQUAL "dev")
    add_definitions(-DENV_DEV)
    add_library(
            remoteenvars-dev
            SHARED
            remoteenvars.cpp
    )


elseif (BUILD_TYPE STREQUAL "rel")
    add_definitions(-DENV_REL)
    add_library(
            remoteenvars
            SHARED
            remoteenvars.cpp
    )

else()
    message(FATAL_ERROR "")
endif ()

