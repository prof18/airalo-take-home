package com.prof18.airalo.core.utils

import androidx.annotation.StringRes

interface ResourceProvider {
    fun getString(@StringRes stringRes: Int): String

    fun getString(@StringRes stringRes: Int, vararg arguments: Any): String
}
