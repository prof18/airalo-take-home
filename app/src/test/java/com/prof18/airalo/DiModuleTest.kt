package com.prof18.airalo

import org.junit.Test
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.test.verify.verify

@OptIn(KoinExperimentalAPI::class)
class DiModuleTest {

    @Test
    fun checkKoinModule() {
        // Verify Koin configuration
        com.prof18.airalo.airaloAppModule.verify(
            extraTypes = listOf(android.content.Context::class),
        )
    }
}
