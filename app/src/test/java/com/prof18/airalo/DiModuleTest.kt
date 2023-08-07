package com.prof18.airalo

import org.junit.Test
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.test.verify.verify

@OptIn(KoinExperimentalAPI::class)
class DiModuleTest {
    @Test
    fun `Verify that the DI graph is setup correctly`() {
        airaloAppModule.verify(
            extraTypes = listOf(android.content.Context::class),
        )
    }
}
