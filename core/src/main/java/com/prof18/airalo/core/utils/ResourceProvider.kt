package com.prof18.airalo.core.utils

import androidx.annotation.StringRes

/**
 * A wrapper to be able to get localised strings in context free scenarios, like a ViewModel
 */
interface ResourceProvider {
    fun getString(@StringRes stringRes: Int): String

    fun getString(@StringRes stringRes: Int, vararg arguments: Any): String
}
