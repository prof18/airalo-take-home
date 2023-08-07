package com.prof18.airalo

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.prof18.airalo.countrychooser.contract.CountriesContract
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

    private val countriesContract: CountriesContract by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*
            For this sample, the country selection Activity is always started.
            In a real situation there should be a ViewModel that checks some status
            (e.g. user logged in or out) and decide where to navigate.
         */
        startActivity(
            countriesContract.getIntent(this),
        )
    }
}
