package com.prof18.airalo

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.prof18.airalo.countrychooser.contract.CountriesContract
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

    private val countriesContract: CountriesContract by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Decide what to open -> In the future open the onboarding activity if it's a new user
        startActivity(
            countriesContract.getIntent(this),
        )

    }
}
