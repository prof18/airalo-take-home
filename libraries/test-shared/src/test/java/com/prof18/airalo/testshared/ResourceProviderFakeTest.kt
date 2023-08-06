package com.prof18.airalo.testshared

import com.prof18.airalo.core.R
import junit.framework.TestCase.assertEquals
import org.junit.After
import org.junit.Test

class ResourceProviderFakeTest {

    private val resProvider = ResourceProviderFake

    @After
    fun clear() {
        resProvider.clear()
    }

    @Test
    fun `When a string without arguments is required, then the correct string is returned`() {
        resProvider.setValue(R.string.retry_button, "Retry")

        val string = resProvider.getString(R.string.retry_button)

        assertEquals("Retry", string)
    }

    @Test
    fun `When a string with arguments is required, then the correct string is returned`() {
        val stringToReturn = "string-with-params"
        resProvider.setValue(R.string.retry_button, stringToReturn, "arg1", "arg2")

        val string = resProvider.getString(R.string.retry_button, "arg1", "arg2")

        assertEquals(stringToReturn, string)
    }
}
