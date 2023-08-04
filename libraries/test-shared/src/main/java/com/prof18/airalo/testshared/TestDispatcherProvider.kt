package com.prof18.airalo.testshared

import com.prof18.airalo.core.coroutines.DispatcherProvider
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher

class TestDispatcherProvider : DispatcherProvider {

    override fun io(): CoroutineDispatcher = testDispatcher

    override fun main(): CoroutineDispatcher = testDispatcher

    override fun mainImmediate(): CoroutineDispatcher = testDispatcher

    override fun default(): CoroutineDispatcher = testDispatcher

    override fun unconfined(): CoroutineDispatcher = testDispatcher

    @OptIn(ExperimentalCoroutinesApi::class)
    companion object {
        val testDispatcher = UnconfinedTestDispatcher()
    }
}
