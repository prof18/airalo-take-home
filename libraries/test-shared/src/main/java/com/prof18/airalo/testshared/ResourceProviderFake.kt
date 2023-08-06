package com.prof18.airalo.testshared

import androidx.annotation.StringRes
import com.prof18.airalo.core.utils.ResourceProvider

object ResourceProviderFake : ResourceProvider {

    private val stringMap = mutableMapOf<String, String>()

    fun clear() {
        stringMap.clear()
    }

    fun setValue(@StringRes stringRes: Int, stringToReturn: String, vararg arguments: Any) {
        stringMap[getKeyWithArguments(stringRes, arguments)] = stringToReturn
    }

    fun setValue(@StringRes stringRes: Int, stringToReturn: String) {
        stringMap[getKey(stringRes)] = stringToReturn
    }

    override fun getString(@StringRes stringRes: Int): String {
        val key = getKey(stringRes)
        return stringMap.getOrDefault(key, "default-fake-string")
    }

    private fun getKey(@StringRes stringRes: Int) = stringRes.toString()

    override fun getString(@StringRes stringRes: Int, vararg arguments: Any): String {
        val key = getKeyWithArguments(stringRes, arguments)
        return stringMap.getOrDefault(key, "default-fake-string")
    }

    private fun getKeyWithArguments(@StringRes stringRes: Int, arguments: Array<out Any>): String {
        val argumentsKey = arguments.joinToString("-")
        return "$stringRes-$argumentsKey"
    }
}
