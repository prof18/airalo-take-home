package com.prof18.airalo.countrypackages

import android.app.Activity
import com.prof18.airalo.countrypackages.contract.AboutContract
import com.prof18.airalo.core.utils.launchActivity
import org.koin.core.annotation.Factory

@Factory
internal class AboutContractImpl : AboutContract {
    override fun launch(currentActivity: Activity) {
        currentActivity.launchActivity(AboutActivity::class.java)
    }
}
