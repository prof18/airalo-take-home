package com.prof18.airalo.countrychooser.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.prof18.airalo.countrychooser.presentation.components.CountriesScreen
import com.prof18.airalo.countrypackages.contract.CountryPackagesContract
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class CountriesActivity : ComponentActivity() {

    private val countryPackagesContract: CountryPackagesContract by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: CountriesViewModel by viewModel()

        setContent {
            val state by viewModel.countriesState.collectAsStateWithLifecycle()

            CountriesScreen(
                state = state,
                onCountryClick = { countryId ->
                    countryPackagesContract.startFeature(
                        currentActivity = this@CountriesActivity,
                        countryId = countryId,
                    )
                },
            )
        }

        viewModel.fetchCountries()
    }
}
