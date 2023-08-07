package com.prof18.airalo.countrychooser.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prof18.airalo.core.R
import com.prof18.airalo.core.architecture.DataResult
import com.prof18.airalo.core.model.CountryId
import com.prof18.airalo.core.utils.ResourceProvider
import com.prof18.airalo.countrychooser.domain.model.Country
import com.prof18.airalo.countrychooser.domain.usecases.CountriesUseCase
import com.prof18.airalo.countrychooser.presentation.state.CountriesState
import com.prof18.airalo.countrychooser.presentation.state.CountriesState.Content.CountryItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel
import timber.log.Timber

@KoinViewModel
internal class CountriesViewModel(
    private val countriesUseCase: CountriesUseCase,
    private val resourceProvider: ResourceProvider,
) : ViewModel() {

    private val countriesMutableState = MutableStateFlow<CountriesState>(CountriesState.Loading)
    val countriesState: StateFlow<CountriesState> = countriesMutableState.asStateFlow()

    fun fetchCountries() {
        countriesMutableState.update {
            CountriesState.Loading
        }
        viewModelScope.launch {
            when (val result = countriesUseCase.getPopularCountries()) {
                is DataResult.Success -> {
                    val countries = result.data
                    if (countries.isEmpty()) {
                        Timber.w("The country list is empty")
                        emitError(
                            errorMessage = resourceProvider.getString(R.string.no_countries),
                            retryAction = {
                                fetchCountries()
                            },
                        )
                        return@launch
                    }
                    emitState(countries)
                }

                is DataResult.Error -> {
                    Timber.e(result.throwable, "Error while getting the countries list")
                    emitError(
                        errorMessage = resourceProvider.getString(R.string.error_message),
                        retryAction = {
                            fetchCountries()
                        },
                    )
                }
            }
        }
    }

    private fun emitState(countries: List<Country>) {
        countriesMutableState.update {
            CountriesState.Content(
                headerTitle = resourceProvider.getString(R.string.popular_countries_header),
                countryItems = countries
                    .sortedBy { it.name }
                    .map { country ->
                        country.toCountryItem()
                    },
            )
        }
    }

    private fun Country.toCountryItem(): CountryItem =
        CountryItem(
            id = CountryId(this.id),
            name = this.name,
            flagImageUrl = this.flagImageUrl,
        )

    private fun emitError(
        errorMessage: String,
        retryAction: () -> Unit,
    ) {
        val retryButtonText = resourceProvider.getString(R.string.retry_button)

        countriesMutableState.update {
            CountriesState.Error(
                content = errorMessage,
                retryButtonText = retryButtonText,
                onRetryClick = {
                    retryAction()
                },
            )
        }
    }
}
