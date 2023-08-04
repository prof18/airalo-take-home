package com.prof18.airalo.countrychooser.contract

import android.app.Activity
import android.content.Intent

interface HomeContract {
    fun getIntent(currentActivity: Activity): Intent
}
