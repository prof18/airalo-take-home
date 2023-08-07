package com.prof18.airalo.testsutils

import com.prof18.airalo.core.coroutines.DispatcherProvider
import com.prof18.airalo.core.di.CoreModule
import com.prof18.airalo.core.utils.ResourceProvider
import org.junit.After
import org.junit.Rule
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.module.Module
import org.koin.dsl.module
import org.koin.ksp.generated.module
import org.koin.test.KoinTest

/**
 * A Base class to write a ViewModel integration test.
 *
 * The class provides some helpers to initialize the DI graph, to be able to exercise the real
 * dependencies during the VM tests.
 */
abstract class BaseViewModelTest : KoinTest {

    @get:Rule
    internal val mainCoroutineRule = MainCoroutineRule(TestDispatcherProvider.main())

    /**
     * A fake version of the ResourceProvider
     *
     * - Use `resourceProvider.setValue(R.string.key, "string-to-return")` to set a string
     *    without arguments
     * - Use `resourceProvider.setValue(R.string.key, "string-to-return", "arg1", "arg2")` to set
     *    a string with one or more arguments
     *
     * All the faked strings are cleared after every test run
     */
    val resourceProviderFake = ResourceProviderFake

    /**
     * A Koin module to provide some Fake dependencies
     */
    private val testingModule = module {
        factory<ResourceProvider> { resourceProviderFake }
        factory<DispatcherProvider> { TestDispatcherProvider }
    }

    /**
     * Initialize the DI graph for the ViewModel test. A set of common and fakes modules are
     * already initialized and additional modules can be provided as a parameter.
     *
     * @param additionalModule Provide one or multiple modules to the DI Graph
     * @param moduleProvider A lambda with a Koin instance as receiver, to add additional dependencies to the graph
     */
    fun initKoin(
        vararg additionalModule: Module = emptyArray(),
        moduleProvider: Module.() -> Unit = {},
    ) {
        startKoin {
            allowOverride(true)
            modules(CoreModule().module)
            modules(
                testingModule,
            )
            modules(additionalModule.toList())
            modules(
                module {
                    moduleProvider.invoke(this)
                },
            )
        }
    }

    @After
    open fun tearDown() {
        ResourceProviderFake.clear()
        stopKoin()
    }
}
