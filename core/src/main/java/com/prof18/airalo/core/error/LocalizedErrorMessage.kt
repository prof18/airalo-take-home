package com.prof18.airalo.core.error

import androidx.annotation.StringRes

data class LocalizedErrorMessage(
    @StringRes val messageStringResID: Int,
    @StringRes val buttonTextResId: Int,
)
