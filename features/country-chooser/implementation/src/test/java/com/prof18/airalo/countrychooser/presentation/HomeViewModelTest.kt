package com.prof18.airalo.countrychooser.presentation

import com.prof18.airalo.testshared.testCoroutineDispatcherProvider
import com.prof18.airalo.testshared.MainCoroutineRule
import org.junit.Rule

class HomeViewModelTest {

    @get:Rule
    val coroutineRule = MainCoroutineRule(testCoroutineDispatcherProvider.main)
}
