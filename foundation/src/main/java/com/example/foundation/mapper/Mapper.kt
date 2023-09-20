package com.example.foundation.mapper

interface Mapper<T, R> {
    operator fun invoke(param: T): R
}