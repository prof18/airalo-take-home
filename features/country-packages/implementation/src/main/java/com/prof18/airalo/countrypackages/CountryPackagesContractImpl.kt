package com.prof18.airalo.countrypackages

import android.app.Activity
import android.content.Intent
import com.prof18.airalo.core.model.CountryId
import com.prof18.airalo.countrypackages.contract.CountryPackagesContract
import com.prof18.airalo.countrypackages.presentation.CountryPackagesActivity
import org.koin.core.annotation.Factory

@Factory
internal class CountryPackagesContractImpl : CountryPackagesContract {
    override fun launch(
        currentActivity: Activity,
        countryId: CountryId,
    ) {
        val intent = Intent(currentActivity, CountryPackagesActivity::class.java).apply {
            putExtra(CountryPackagesActivity.COUNTRY_ID_EXTRA_KEY, countryId.value)
            action = Intent.ACTION_VIEW
        }

        currentActivity.startActivity(intent)
    }
}
