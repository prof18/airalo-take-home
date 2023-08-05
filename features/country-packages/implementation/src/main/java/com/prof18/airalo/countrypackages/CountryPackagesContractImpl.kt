package com.prof18.airalo.countrypackages

import android.app.Activity
import com.prof18.airalo.core.utils.launchActivity
import com.prof18.airalo.countrypackages.contract.CountryPackagesContract
import com.prof18.airalo.countrypackages.presentation.CountryPackagesActivity
import org.koin.core.annotation.Factory

@Factory
internal class CountryPackagesContractImpl : CountryPackagesContract {
    override fun launch(currentActivity: Activity) {
        currentActivity.launchActivity(CountryPackagesActivity::class.java)
    }
}
