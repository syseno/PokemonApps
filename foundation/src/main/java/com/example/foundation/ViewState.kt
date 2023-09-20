package com.example.foundation

sealed class ViewState<out T> {
    data class Loading<out T>(val state: Boolean) : ViewState<T>()
    data class Success<out T>(val data: T) : ViewState<T>()
    data class Failure<out T>(val throwable: Throwable) : ViewState<T>()
}
