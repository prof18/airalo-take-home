package com.prof18.airalo.countrychooser.presentation

import com.prof18.airalo.testshared.MainCoroutineRule
import com.prof18.airalo.testshared.TestDispatcherProvider
import org.junit.Rule

class HomeViewModelTest {

    @get:Rule
    val coroutineRule = MainCoroutineRule(TestDispatcherProvider.main())
}
