package com.prof18.airalo.countrypackages.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.prof18.airalo.countrypackages.domain.model.CountryId
import com.prof18.airalo.countrypackages.presentation.components.PackagesScreen
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class CountryPackagesActivity : ComponentActivity() {

    private val viewModel: CountryPackagesViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val countryId = requireNotNull(
            intent.getStringExtra(COUNTRY_ID_EXTRA_KEY),
        )

        setContent {
            val state by viewModel.countryPackagesState.collectAsStateWithLifecycle()

            PackagesScreen(
                packagesState = state,
                onBackClick = {
                    finish()
                },
            )
        }

        viewModel.fetchPackages(CountryId(value = countryId))
    }

    internal companion object {
        const val COUNTRY_ID_EXTRA_KEY = "country_id_extra_key"
    }
}
