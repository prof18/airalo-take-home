@file:OptIn(ExperimentalContracts::class)

package com.prof18.airalo.core.architecture

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

/**
 * A class that encapsulates a successful outcome with a value of type [T] or a failure
 * with an arbitrary [Throwable] exception
 */
sealed class DataResult<out T> {
    data class Success<T>(val data: T) : DataResult<T>()
    data class Error(val throwable: Throwable) : DataResult<Nothing>()
}

/**
 * Returns true if the [DataResult] is of type [DataResult.Error], otherwise false.
 */
fun <T> DataResult<T>.isError(): Boolean {
    contract {
        returns(true) implies (this@isError is DataResult.Error)
    }
    return this is DataResult.Error
}

/**
 * If the receiver is of type [DataResult.Success], the method applies the given transform function to [T] and returns
 * the result as [DataResult.Success]
 *
 * If the receiver is of type [DataResult.Error], the method returns the receiver without applying any transformation
 */
inline fun <reified T, R> DataResult<T>.mapIfSuccess(transform: (T) -> R): DataResult<R> {
    if (isError()) {
        return this
    }

    val data = this.requireSuccess()
    val mappedData = transform(data)
    return DataResult.Success(mappedData)
}

/**
 * Throws an IllegalArgumentException, if the receiver is not of type [DataResult.Success]
 */
inline fun <reified T> DataResult<T>.requireSuccess(): T {
    require(this is DataResult.Success) {
        "DataResult should be a success"
    }
    return this.data
}
