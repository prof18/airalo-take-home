@file:OptIn(ExperimentalContracts::class)

package com.prof18.airalo.core.architecture

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

// TODO: delete unused helpers

/**
 * A wrapper to contain successful and failure states
 */
sealed class DataResult<out T> {
    data class Success<T>(val data: T) : DataResult<T>()
    data class Error(val throwable: Throwable) : DataResult<Nothing>()
}

fun <T> DataResult<T>.isSuccess(): Boolean {
    contract {
        returns(true) implies (this@isSuccess is DataResult.Success)
    }
    return this is DataResult.Success
}

fun <T> DataResult<T>.isError(): Boolean {
    contract {
        returns(true) implies (this@isError is DataResult.Error)
    }
    return this is DataResult.Error
}

inline fun <reified T, R> DataResult<T>.mapIfSuccess(transform: (T) -> R): DataResult<R> {
    if (isError()) {
        return this
    }

    val data = this.requireSuccess()
    val mappedData = transform(data)
    return DataResult.Success(mappedData)
}

inline fun <reified T> DataResult<T>.requireSuccess(): T {
    require(this is DataResult.Success) {
        "DataResult should be a success"
    }
    return this.data
}

fun <T> DataResult<T>.requireError(): Throwable {
    require(this is DataResult.Error) {
        "DataResult should be a success"
    }
    return this.throwable
}
