package com.prof18.airalo.core.utils

import android.app.Activity
import android.content.Intent

fun <T : Activity> Activity.launchActivity(clazz: Class<T>) {
    startActivity(
        Intent(this, clazz)
            .setAction(Intent.ACTION_VIEW),
    )
}
