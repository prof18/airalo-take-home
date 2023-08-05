package com.prof18.airalo

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.prof18.airalo.countrychooser.contract.CountriesContract
import com.prof18.airalo.countrypackages.contract.CountryPackagesContract
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

    private val countriesContract: CountriesContract by inject()
    private val aboutContract: CountryPackagesContract by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Decide what to open -> In the future open the onboarding activity if it's a new user
        // TODO: restore
        // startActivity(
        //     countriesContract.getIntent(this),
        // )

        aboutContract.launch(this)

    }
}
