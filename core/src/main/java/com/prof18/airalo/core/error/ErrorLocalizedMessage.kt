package com.prof18.airalo.core.error

import androidx.annotation.StringRes

data class ErrorLocalizedMessage(
    @StringRes val messageStringResID: Int,
    @StringRes val buttonTextResId: Int,
)
