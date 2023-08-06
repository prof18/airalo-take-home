package com.prof18.airalo.core.utils

import android.content.Context
import androidx.annotation.StringRes
import org.koin.core.annotation.Singleton

@Singleton
class ResourceProviderImpl(
    private val context: Context,
) : ResourceProvider {
    override fun getString(@StringRes stringRes: Int): String = context.getString(stringRes)

    override fun getString(@StringRes stringRes: Int, vararg arguments: Any): String {
        return if (arguments.isNotEmpty()) {
            context.getString(stringRes, *arguments)
        } else {
            context.getString(stringRes)
        }
    }
}
