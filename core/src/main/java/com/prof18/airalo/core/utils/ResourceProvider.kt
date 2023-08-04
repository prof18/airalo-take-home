package com.prof18.airalo.core.utils

import android.content.Context
import androidx.annotation.StringRes
import org.koin.core.annotation.Singleton

@Singleton
class ResourceProvider(
    private val context: Context,
) {

    fun getString(@StringRes stringRes: Int): String = context.getString(stringRes)

    @Suppress("SpreadOperator")
    fun getString(@StringRes resourceIdentifier: Int, vararg arguments: Any): String {
        return if (arguments.isNotEmpty()) {
            context.getString(resourceIdentifier, *arguments)
        } else {
            context.getString(resourceIdentifier)
        }
    }
}
