package com.prof18.airalo.countrychooser

import android.app.Activity
import android.content.Intent
import com.prof18.airalo.countrychooser.contract.CountriesContract
import com.prof18.airalo.countrychooser.presentation.CountriesActivity
import org.koin.core.annotation.Factory

@Factory
class CountriesContractImpl : CountriesContract {
    override fun getIntent(currentActivity: Activity): Intent =
        Intent(currentActivity, CountriesActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or
                Intent.FLAG_ACTIVITY_CLEAR_TASK or
                Intent.FLAG_ACTIVITY_NO_ANIMATION
        }
}
