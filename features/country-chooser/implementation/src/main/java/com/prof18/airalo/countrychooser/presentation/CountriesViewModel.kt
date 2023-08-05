package com.prof18.airalo.countrychooser.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prof18.airalo.core.R
import com.prof18.airalo.core.architecture.DataResult
import com.prof18.airalo.core.error.LocalizedErrorMessage
import com.prof18.airalo.core.error.NetworkError
import com.prof18.airalo.core.error.getErrorLocalizedMessage
import com.prof18.airalo.core.utils.ResourceProvider
import com.prof18.airalo.countrychooser.domain.model.Country
import com.prof18.airalo.countrychooser.domain.usecases.CountriesUseCase
import com.prof18.airalo.countrychooser.presentation.state.CountriesState
import com.prof18.airalo.countrychooser.presentation.state.CountriesState.Content.CountryItem
import com.prof18.airalo.countrychooser.presentation.state.CountriesState.Content.CountryItem.CountryId
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

    private val homeMutableState = MutableStateFlow<CountriesState>(CountriesState.Loading)
    val countriesState: StateFlow<CountriesState> = homeMutableState.asStateFlow()

    init {
        fetchCountries()
    }

    private fun fetchCountries() {
        homeMutableState.update {
            CountriesState.Loading
        }
        viewModelScope.launch {
            when (val result = countriesUseCase.getCountries()) {
                is DataResult.Success -> {
                    val countries = result.data
                    if (countries.isEmpty()) {
                        Timber.w("The country list is empty")
                        emitError(
                            localizedMessage = LocalizedErrorMessage(
                                messageStringResID = R.string.no_countries,
                                buttonTextResId = R.string.retry_button,
                            ),
                            retryAction = {
                                fetchCountries()
                            },
                        )
                        return@launch
                    }
                    emitData(countries)
                }

                is DataResult.Error -> {
                    Timber.e(result.throwable, "Error while getting the countries list")
                    val localizedMessage = result.throwable.generateErrorLocalizedMessage()
                    emitError(
                        localizedMessage = localizedMessage,
                        retryAction = {
                            fetchCountries()
                        },
                    )
                }
            }
        }
    }

    private fun emitData(countries: List<Country>) {
        homeMutableState.update {
            CountriesState.Content(
                headerTitle = resourceProvider.getString(R.string.popular_countries_header),
                countryItems = countries.map { country ->
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
        localizedMessage: LocalizedErrorMessage,
        retryAction: () -> Unit,
    ) {
        homeMutableState.update {
            CountriesState.Error(
                content = resourceProvider.getString(
                    localizedMessage.messageStringResID,
                ),
                buttonText = resourceProvider.getString(
                    localizedMessage.buttonTextResId,
                ),
                onRetryClick = {
                    retryAction()
                },
            )
        }
    }

    private fun Throwable.generateErrorLocalizedMessage(): LocalizedErrorMessage =
        when (this) {
            is NetworkError.ApiError -> {
                // Do here some custom mapping based on the error
                LocalizedErrorMessage(
                    messageStringResID = R.string.unknown_network_error_message,
                    buttonTextResId = R.string.retry_button,
                )
            }

            is NetworkError -> {
                this.getErrorLocalizedMessage()
            }

            else -> {
                LocalizedErrorMessage(
                    messageStringResID = R.string.unknown_network_error_message,
                    buttonTextResId = R.string.retry_button,
                )
            }
        }
}
