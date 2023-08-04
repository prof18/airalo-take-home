package com.prof18.airalo.countrychooser.contract

import android.app.Activity
import android.content.Intent

interface CountriesContract {
    fun getIntent(currentActivity: Activity): Intent
}
