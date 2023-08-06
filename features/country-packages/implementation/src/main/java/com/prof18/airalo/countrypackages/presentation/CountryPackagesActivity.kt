package com.prof18.airalo.countrypackages.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.prof18.airalo.countrypackages.domain.model.CountryId
import com.prof18.airalo.countrypackages.presentation.components.PackagesScreen
import com.prof18.airalo.designsystem.theme.AiraloTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class CountryPackagesActivity : ComponentActivity() {

    private val viewModel: CountryPackagesViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val countryId = intent.getStringExtra(COUNTRY_ID_EXTRA_KEY)
        requireNotNull(countryId)

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

@Composable
private fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
    )
}

@Preview(showBackground = true)
@Composable
private fun GreetingPreview() {
    AiraloTheme {
        Greeting("Android")
    }
}
