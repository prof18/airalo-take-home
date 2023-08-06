package com.prof18.airalo.testshared

import com.prof18.airalo.core.coroutines.DispatcherProvider
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher

@OptIn(ExperimentalCoroutinesApi::class)
object TestDispatcherProvider : DispatcherProvider {

    var testDispatcher = UnconfinedTestDispatcher()

    override fun io(): CoroutineDispatcher = testDispatcher

    override fun main(): CoroutineDispatcher = testDispatcher

    override fun mainImmediate(): CoroutineDispatcher = testDispatcher

    override fun default(): CoroutineDispatcher = testDispatcher

    override fun unconfined(): CoroutineDispatcher = testDispatcher
}
