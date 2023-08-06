package com.prof18.airalo.countrypackages.contract

import android.app.Activity
import com.prof18.airalo.core.model.CountryId

interface CountryPackagesContract {
    fun launch(
        currentActivity: Activity,
        countryId: CountryId,
    )
}
